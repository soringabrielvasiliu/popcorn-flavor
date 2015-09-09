package controller;

import model.ActorsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/actor")
@RequestMapping
public class ActorsController {

	private ActorsModel am = new ActorsModel();

	@RequestMapping(value = "/actor/{idActor}", method = RequestMethod.GET)
	public String getActorById(@PathVariable(value = "idActor") int idActor,
			ModelMap modelMap) {
		System.out.println(idActor);
		modelMap.put("mv", am.getActorById(idActor));
		modelMap.put("otherMovies", am.getOtherMoviesByActorId(idActor));
		return "actor";
	}
}