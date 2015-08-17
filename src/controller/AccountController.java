package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import entities.*;
import model.*;

@Controller
@RequestMapping(value="account")
public class AccountController {

	private AccountModel accountModel = new AccountModel();
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("u", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value="u")User u, ModelMap modelMap, HttpSession session) {
		if (accountModel.login(u.getUsername(), u.getPassword()) != null) {
			session.setAttribute("username", u.getUsername());
			return "redirect:/homepage.html";
		}
		else
		{
			modelMap.put("message", "Account's Invalid");
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:login.html";
	}
}