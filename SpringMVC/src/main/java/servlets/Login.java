package servlets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.LoginController;
import db.DBWorker;
import models.User;

@Controller
@RequestMapping("/Login")
public class Login {
	@RequestMapping(method = RequestMethod.GET)
	public String login() {

		
		return "login";

	}
	@RequestMapping(method = RequestMethod.GET,params = {"login","password"})
	public String login1(@RequestParam("login")  String login ,@RequestParam("password")  String password , HttpSession session) {
		DBWorker worker = new DBWorker();
		LoginController loginController = new LoginController(worker.getSt());
		User user = loginController.checkUser(login , password );
		if (user != null) {
			if (session.getAttribute("user") == null) {
				session.setAttribute("user", user.getName());
				session.setAttribute("users", user);
				System.out.println("start");
			}
			} 
		
		return "login";
	}
	@RequestMapping(method = RequestMethod.GET,params = {"click"})
	public String login2(String password , @RequestParam("click")  String click, HttpSession session) {
		 if (click != null) {
			session.invalidate();

			System.out.println("logout");
		}
		
		return "login";
		
	}
}
