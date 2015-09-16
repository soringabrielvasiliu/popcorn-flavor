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

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("listMovies", mm.getMovies());
		return "homepage";
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String getMovie(@ModelAttribute(value = "searchName") String searchName,
			ModelMap modelMap, HttpSession session) {
		if (searchName != null) {
			modelMap.addAttribute("searchResultsMovies", mm.getMovieDetail(searchName));
			modelMap.addAttribute("searchResultsActors", mm. getActorDetail(searchName));
			return "find";
		}
		else return "find";
			
	}
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public String addMovie(ModelMap modelMap) {
		modelMap.put("mv", new Movie());
		return "addMovie";
	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute(value = "mv") Movie mv,
			ModelMap modelMap) {
		this.mm.create(mv);
		modelMap.put("listMovies", mm.findAll());
		return "redirect:homepage.html";
	}

	@RequestMapping(value = "/deleteMovie/{idMovie}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		this.mm.delete(this.mm.find(idMovie));
		modelMap.put("listMovies", mm.findAll());
		return "redirect:/homepage.html";
	}

	@RequestMapping(value = "/editMovie/{idMovie}", method = RequestMethod.GET)
	public String editMovie(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		modelMap.put("mv", mm.find(idMovie));
		return "editMovie";
	}

	@RequestMapping(value = "/editMovie", method = RequestMethod.POST)
	public String editMovie(@ModelAttribute(value = "mv") Movie mv,
			ModelMap modelMap) {
		this.mm.update(mv);
		modelMap.put("listMovies", mm.findAll());
		return "redirect:homepage.html";
	}

	@RequestMapping(value = "/movie/{idMovie}", method = RequestMethod.GET)
	public String getMovieById(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		modelMap.put("mv", mm.getMovieById(idMovie));
		modelMap.put("genre", mm.getMovieGenres(idMovie));
		modelMap.put("cast", mm.getMovieCast(idMovie));
		modelMap.put("comments", mm.getComment(idMovie));
		if (AccountController.username != null) 
			modelMap.put("verifyRating", mm.verifyExistingRating(idMovie,AccountController.username));
			modelMap.put("verifyWatchlist", mm.verifyExistingWatchlist(idMovie,AccountController.username));
			modelMap.put("verifyMoviePref", mm.verifyExistingMoviePref(idMovie,AccountController.username));
		return "movie";
	}
	
	@RequestMapping(value = "/movie/{idMovie}", method = RequestMethod.POST)
	public String insertComment( @PathVariable(value = "idMovie") int idMovie , @ModelAttribute (value = "comment") String comment, @ModelAttribute (value = "rating") String rating, ModelMap modelMap,  HttpSession session) {
		String verifyRating = null;
		if (AccountController.username != null) {
			 verifyRating = mm.verifyExistingRating(idMovie,AccountController.username);
			if (verifyRating == null) {
				mm.postCommentWithoutRating(comment, idMovie , AccountController.username);
				return "redirect:/movie/{idMovie}.html";
			}
			else
			{
				mm.postCommentWithtRating(comment, idMovie , AccountController.username, rating);
				int intRating = Integer.parseInt(rating);
				mm.updateRating( intRating, idMovie);
				return "redirect:/movie/{idMovie}.html";
			}			
		} else
			return "redirect:/account/login.html";
	}
	
	@RequestMapping(value = "/movie/{idMovie}/addToWatchlist", method = RequestMethod.GET)
	public String addToWatchlist(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		if (AccountController.username != null)
			mm.addToWatchlist(idMovie, AccountController.username);
		return "movie";
	}
	
	@RequestMapping(value = "/movie/{idMovie}/addToPref", method = RequestMethod.GET)
	public String addToMoviePref(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		System.out.println(idMovie);
		if (AccountController.username != null)
			mm.addToMoviePref(idMovie, AccountController.username);
		return "movie";
	}
	
	@RequestMapping(value = "/movie/{idMovie}/removeFromWatchlist", method = RequestMethod.GET)
	public String removeFromWatchlist(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		if (AccountController.username != null) {
			mm.removeFromWatchlist(idMovie, AccountController.username);
		}
		else
			return "redirect:/account/login.html";
		return "movie";
	}
	
	@RequestMapping(value = "/movie/{idMovie}/removeFromPref", method = RequestMethod.GET)
	public String removeFromMoviePref(@PathVariable(value = "idMovie") int idMovie,
			ModelMap modelMap) {
		System.out.println(idMovie);
		if (AccountController.username != null)
			mm.removeFromMoviePref(idMovie, AccountController.username);
		else
			return "redirect:/account/login.html";
		return "movie";
	}
}

