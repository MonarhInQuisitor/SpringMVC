package servlets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.LoginController;
import controllers.RegistrationController;
import db.DBWorker;
import models.User;

@Controller
@RequestMapping("/Registration")
public class Registration {

	@RequestMapping(method = RequestMethod.GET)
	public String registr() {
		return "registration";
	}

	@RequestMapping(method = RequestMethod.GET, params = { "login", "password", "password1", "name", "radio", "region",
			"textarea" })
	public String registr1(@RequestParam("login") String login, @RequestParam("password") String password,
			@RequestParam("password1") String password1, @RequestParam("name") String name,
			@RequestParam("radio") String radio, @RequestParam("region") String region,
			@RequestParam("textarea") String textarea, HttpSession session, ModelMap map) {
		DBWorker worker = new DBWorker();
		RegistrationController registrationController = new RegistrationController(worker.getSt(), worker.getConn());
		User user = new User();
		user = registrationController.setUser(login, password, password1, radio, region, textarea, name);
		if (session.getAttribute("user") == null) {
			if (registrationController.checkRegistr(user)) {
				System.out.println("servlet 1");
				registrationController.register(user);
				System.out.println(user.toString());
			}

		} else {
			
			registrationController.update(user);
			session.setAttribute("users", user);
			session.setAttribute("user", user.getName());
		}
		return "registration";
	}
}
