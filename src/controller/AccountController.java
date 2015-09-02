package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import entities.*;
import model.*;

@Controller("/account")
@RequestMapping(value = "account")
public class AccountController {

	private static User userSession = null;
	private AccountModel accountModel = new AccountModel();
	private static StringBuffer username = null;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("u", new User());
		return "login";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String veryfyLogIn(ModelMap modelMap) {
		if (userSession!= null) {
			System.out.println("yeeeeeeeees");
			modelMap.put("message", "yes");
		} else {
			System.out.println("Nooooooooooooooo");
			modelMap.put("message", null);
		}
		return "header";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "u") User u, ModelMap modelMap,
			HttpSession session) {
		System.out.println(u.getUsername() + "\t" + u.getPassword());
		if (accountModel.login(u.getUsername(), u.getPassword()) != null) {
			session.setAttribute("username", u.getUsername());
			//userSession.setUsername(u.getUsername());
			username = new StringBuffer(u.getUsername());
			return "redirect:/homepage.html";
		} else {
			modelMap.put("message", "Account's Invalid");
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		userSession = null;
		session.removeAttribute("username");
		return "redirect:login.html";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(ModelMap modelMap) {
		if (userSession.getUsername() != null) {
			User u = accountModel.profile(userSession.getUsername() );
			System.out.println(u.getIdUser() + "\t" + u.getUsername() + "\t"
					+ u.getFirstName() + "\t" + u.getLastName() + "\t"
					+ u.getGenre() + "\t" + u.getMail() + "\t"
					+ u.getPassword());
			modelMap.addAttribute("u", u);
		} else
			return "redirect:/account/login.html";

		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profile(@ModelAttribute(value = "u") User u,
			ModelMap modelMap, HttpSession session) {
		if (userSession.getUsername()  != null) {
			if (accountModel.updateProfile(u, userSession.getUsername() ) != null) {
				userSession.setUsername(u.getUsername());
				System.out.println("job done");
				return "redirect:/account/profile.html";
			}
		}
		else
			return "redirect:/account/login.html";
		return "profile";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(ModelMap modelMap) {
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String  forgotPassword(@ModelAttribute(value = "email") String email,
			ModelMap modelMap, HttpSession session) {
			System.out.println(email);
			accountModel.sendRecoveryEmail(email);
			return "redirect:/account/login.html";
	
	}
	
	

}