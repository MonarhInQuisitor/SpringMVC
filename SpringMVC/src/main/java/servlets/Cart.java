package servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.CartController;
import controllers.ProductController;
import db.DBWorker;
import models.Product;
import models.User;

@Controller
@RequestMapping("/Cart")
public class Cart {

	@RequestMapping(method = RequestMethod.GET)
	public String products() {
		return "cart";
	}

	@RequestMapping(method = RequestMethod.GET, params = { "p" })
	public String products(@RequestParam("p") String p, HttpSession session) {
		DBWorker worker = new DBWorker();
		ProductController productController = new ProductController(worker.getSt());
		if (session.getAttribute("cart") == null) {

			CartController cart = new CartController();
			session.setAttribute("cart", cart);
		}
		CartController cart = (CartController) session.getAttribute("cart");
		if (p != null) {
			int productId = Integer.parseInt(p);
			System.out.println("productId" + productId);
			Product product = productController.getProductById(productId);
			cart.addProduct(product);
		}
		cart.Price();
		System.out.println(cart.getSum());
		session.setAttribute("cartcontroller",cart);
		session.setAttribute("count",cart.Count());
		return "cart";
	}

	@RequestMapping(method = RequestMethod.GET, params = { "ch","id" })
	public String products(@RequestParam("ch") String ch, @RequestParam("id") String id,
			HttpSession session) {
		DBWorker worker = new DBWorker();
		ProductController productController = new ProductController(worker.getSt());
	
		if (session.getAttribute("cart") == null) {

			CartController cart = new CartController();
			session.setAttribute("cart", cart);
		}
		CartController cart = (CartController) session.getAttribute("cart");
		System.out.println("asdf");
		if (ch != null && id != null) {
			Product product = productController.getProductById(Integer.parseInt(id));
			

			System.out.println("s=" + ch + "  id=  " + id);
			cart.add(ch, product);

		}
		cart.Price();
		System.out.println(cart.getSum());
		session.setAttribute("cartcontroller",cart);
		session.setAttribute("count",cart.Count());
		
		return "cart";

	}
	
	@RequestMapping(method = RequestMethod.GET, params = { "click" })
	public String products1(@RequestParam("click") String click, HttpSession session) {
		DBWorker worker = new DBWorker();
		ProductController productController = new ProductController(worker.getSt());
		CartController cart = (CartController) session.getAttribute("cart");
		if(click!=null) {
			System.out.println("click  "+click);
			int id  = Integer.parseInt(click);
			System.out.println("id "+id);
			cart.deleteProductAll(productController.getProductById(id));
		}
		cart.Price();
		System.out.println(cart.getSum());
		session.setAttribute("cartcontroller",cart);
		session.setAttribute("count",cart.Count());
		return "cart";
	}
	@RequestMapping(method = RequestMethod.GET, params = { "buy" })
	public String products1(@RequestParam("buy") String buy, ModelMap map, HttpSession session) {
		
		if(buy!=null)	{
			CartController cart= new CartController();
			session.setAttribute("cart",cart);
			session.setAttribute("cartcontroller",cart);
			session.setAttribute("count",cart.Count());
map.addAttribute("end","ожидайте наши операторы свяжутся с Вами");
		}
		return "cart";
		
	}

}
