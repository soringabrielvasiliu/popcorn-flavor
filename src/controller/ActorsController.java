package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.ActorsModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Actor;

@Controller("/actors")
@RequestMapping
public class ActorsController {

	private ActorsModel am = new ActorsModel();
	
	@RequestMapping(value="/homepage", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("listActors", am.findAll());
		return "homepage";
	}
	
//	@RequestMapping(value="/homepage",  method = RequestMethod.POST)
//	public String index(ModelMap modelMap) {
//		modelMap.put("listActors", am.findAll());
//		return "homepage";
//	}
	
	@RequestMapping(value="/homepage", method = RequestMethod.POST)
	public List<Actor> getActor(@ModelAttribute(value="searchName")String searchName, ModelMap modelMap, HttpSession session) {
		List<Actor> listActors = Collections.synchronizedList (new ArrayList<Actor>());
		listActors = am.getActorDetail(searchName);
		if( listActors != null) {
			modelMap.addAttribute(listActors);
//			for (Actor a : listActors) {
//			System.out.println(a.getIdActor() + "\t" + a.getFirstName()
//					+ "\t" + a.getLastName() + "\t" + a.getNickname()
//					+ "\t" + a.getDateBirth() + "\t" + a.getDateDeath()
//					+ "\t" + a.getBiography() + "\t" + a.getHeight());
//		}
			modelMap.addAttribute("message", listActors);
			return listActors;
		}
		else
		{
			modelMap.put("message", "No result");
			return null;
		}
	}
	
	@RequestMapping(value="/addActor", method = RequestMethod.GET)
	public String addActor(ModelMap modelMap) {
		modelMap.put("ac", new Actor());
		return "addActor";
	}
	
	@RequestMapping(value="/addActor", method = RequestMethod.POST)
	public String addActor(@ModelAttribute(value="ac") Actor ac, ModelMap modelMap) {
		this.am.create(ac);
		modelMap.put("listActors", am.findAll());
		return "redirect:homepage.html";
	}
	
	@RequestMapping(value="/deleteActor/{idActor}", method = RequestMethod.GET)
	public String deleteActor(@PathVariable(value="idActor") int idActor, ModelMap modelMap) {
		this.am.delete(this.am.find(idActor));
		modelMap.put("listActors", am.findAll());
		return "redirect:/homepage.html";
	}
	
	@RequestMapping(value="/editActor/{idActor}", method = RequestMethod.GET)
	public String editActor(@PathVariable(value="idActor") int idActor, ModelMap modelMap) {
		modelMap.put("ac", am.find(idActor));
		return "editActor";
	}
	
	@RequestMapping(value="/editActor", method = RequestMethod.POST)
	public String editActor(@ModelAttribute(value = "ac") Actor ac, ModelMap modelMap) {
		this.am.update(ac);
		modelMap.put("listActors", am.findAll());
		return "redirect:homepage.html";
	}
	
}
