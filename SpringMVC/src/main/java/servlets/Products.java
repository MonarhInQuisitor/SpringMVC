package servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.ProductController;
import db.DBWorker;
import models.Product;
import models.User;

@Controller
@RequestMapping("/Products")
public class Products {

	@RequestMapping(method = RequestMethod.GET)
	public String products(ModelMap map, HttpSession session) {
		if (session.getAttribute("users") != null) {

			User user = (User) session.getAttribute("users");
			map.addAttribute("sessia", user.getLogin());
		}
		return "products";
	}

	@RequestMapping(method = RequestMethod.GET, params = { "prod" })
	public String products(@RequestParam("prod") String prod, ModelMap map, HttpSession session) {
		DBWorker worker = new DBWorker();
		ProductController productController = new ProductController(worker.getSt());
		List<Product> products = productController.getProducts();
		if (session.getAttribute("users") != null) {

			User user = (User) session.getAttribute("users");
			map.addAttribute("sessia", user.getLogin());
		}
		if (prod == null) {
			map.addAttribute("products", products);
			return "products";
		} else {
			int prod1 = Integer.parseInt(prod);
			List<Product> produc = productController.getProductsCategory(prod1);
			map.addAttribute("products", produc);
			map.addAttribute("category", productController.getCategory(prod1));
			System.out.println("p41");

			return "productsCategory";

		}

	}

	@RequestMapping(method = RequestMethod.GET, params = { "id" })
	public String productsDetal(@RequestParam("id") String id, ModelMap map) {
		DBWorker worker = new DBWorker();
		ProductController productController = new ProductController(worker.getSt());
		int id1 = Integer.parseInt(id);
		Product product = productController.getProductById(id1);
		map.addAttribute("product", product);

		return "productsDetal";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET, params = { "price", "description", "category", "name","asd" })
	public String productsDetal(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("category") String category, @RequestParam("price") String price,@RequestParam("asd") String asd, ModelMap map,
			HttpSession session) {
		if (session.getAttribute("users") != null) {

			User user = (User) session.getAttribute("users");
			map.addAttribute("sessia", user.getLogin());
		}
		
		if (map.addAttribute("asd") != null) {
			DBWorker worker = new DBWorker();
			ProductController productController = new ProductController(worker.getSt(), worker.getConn());
			productController.req(name,price,description,category);

		}
		return "productsDetal";

	}
}