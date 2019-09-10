package com.jcg.spring.hibernate.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.spring.hibernate.pojo.User;
/*import com.evry.bankapp.controller.HttpServletRequest;
import com.evry.bankapp.controller.HttpServletResponse;
import com.evry.bankapp.support.Account;*/
import com.jcg.spring.hibernate.service.AuthService;

@Controller
public class LoginCtrl {

	@Autowired
	private AuthService authenticateService; // This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(LoginCtrl.class);

	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateUsr(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String msg = "";
		boolean isValid = authenticateService.findUser(username, password);
		log.info("Is user valid?= " + isValid);

		if (isValid) {
			msg = "Welcome " + username + "!";
		} else {
			msg = "Invalid credentials";
		}
		return new ModelAndView("result", "output", msg);
	}

	@RequestMapping(value = "/delete")
	public ModelAndView deleteUser() {
		return new ModelAndView("deleteProcess");
	}
	
	@RequestMapping(value = "/deleteProcess", method = RequestMethod.GET)
	public ModelAndView deleteProcess(@RequestParam("user_id") int id) {
		String msg = "";
		boolean isValid = authenticateService.deleteUser(id);
		log.info("Is user deleted?= " + isValid);
		if (isValid) {
			msg = "Welcome " + "!";
		} else {
			msg = "Invalid credentials";
		}
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/edit")
	public ModelAndView editUser() {
		return new ModelAndView("editProcess");
	}

	@RequestMapping(value = "/create")
	public ModelAndView create() {
		return new ModelAndView("createUser");
	}

	@RequestMapping(value = "/editProcess", method = RequestMethod.POST)
	public ModelAndView editProcess(@ModelAttribute("username") String username,
			@RequestParam("newUsername") String newName) {
		boolean isValid = authenticateService.editUser(username, newName);
		log.info("Is user created?= " + isValid);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView createProcess(@RequestParam("username") String uname, @RequestParam("password") String password) {
		User user = new User();
		String msg="";
		log.info("inputs " + uname + password);
		System.out.println(uname + password);
		user.setName(uname);
		user.setPassword(password);
		boolean isValid = authenticateService.createUser(user);
		log.info("Is user created?= " + isValid);
		msg = "User Created";
		return new ModelAndView("index");
	}

}