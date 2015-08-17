package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import entities.*;
import model.*;

@Controller("/movies")
@RequestMapping
public class MoviesController {
  
  private MoviesModel mm = new MoviesModel();
  
  @RequestMapping(value="/homepage", method = RequestMethod.GET)
  public String index(ModelMap modelMap) {
    modelMap.put("listMovies", mm.findAll());
    return "homepage";
  }

  @RequestMapping(value="/homepage", method = RequestMethod.POST)
  public List<Movie> getMovie(@ModelAttribute(value="searchName")String searchName, ModelMap modelMap, HttpSession session) {
    List<Movie> listMovies = Collections.synchronizedList (new ArrayList<Movie>());
    listMovies = mm.getMovieDetail(searchName);
    if( listMovies != null) {
      modelMap.addAttribute(listMovies);
      modelMap.addAttribute("message", listMovies);
      modelMap.put("listMovies", mm.findAll());
      return listMovies;
    }
    else
    {
      modelMap.put("message", "No result");
      System.out.println("No result");
      return null;
    }
  }

  @RequestMapping(value="/addMovie", method = RequestMethod.GET)
  public String addMovie(ModelMap modelMap) {
    modelMap.put("mv", new Movie());
    return "addMovie";
  }
  
  @RequestMapping(value="/addMovie", method = RequestMethod.POST)
  public String addMovie(@ModelAttribute(value="mv") Movie mv, ModelMap modelMap) {
    this.mm.create(mv);
    modelMap.put("listMovies", mm.findAll());
    return "redirect:homepage.html";
  }
  
  @RequestMapping(value="/deleteMovie/{idMovie}", method = RequestMethod.GET)
  public String deleteMovie(@PathVariable(value="idMovie") int idMovie, ModelMap modelMap) {
    this.mm.delete(this.mm.find(idMovie));
    modelMap.put("listMovies", mm.findAll());
    return "redirect:/homepage.html";
  }
  
  @RequestMapping(value="/editMovie/{idMovie}", method = RequestMethod.GET)
  public String editMovie(@PathVariable(value="idMovie") int idMovie, ModelMap modelMap) {
    modelMap.put("mv", mm.find(idMovie));
    return "editMovie";
  }
  
  @RequestMapping(value="/editMovie", method = RequestMethod.POST)
  public String editMovie(@ModelAttribute(value = "mv") Movie mv, ModelMap modelMap) {
    this.mm.update(mv);
    modelMap.put("listMovies", mm.findAll());
    return "redirect:homepage.html";
  }
}