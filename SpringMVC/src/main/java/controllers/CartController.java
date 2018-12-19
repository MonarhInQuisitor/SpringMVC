package controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import models.Product;



public class CartController {
	private Map<Product, Integer> cart = new HashMap<Product, Integer>();
	private int sum ;
	public void addProduct(Product product) {
		if (cart.containsKey(product)) {
			int qnt = cart.get(product);
			++qnt;
			System.out.println("add "+qnt);
			cart.put(product, qnt);
		} else {
			cart.put(product, 1);
		}
	}
public int getSum() {
		return sum;
	}
public void Price() {
sum =0;
	 Iterator<Product> products=cart.keySet().iterator();
	 while(products.hasNext()) {
		 Product product=products.next();
		 sum+=product.getPrice()*cart.get(product);
	 }
	
}
public int Count() {
int count =0;
	 Iterator<Product> products=cart.keySet().iterator();
	 while(products.hasNext()) {
		 Product product=products.next();
		 count+=cart.get(product);
	 }
	return count;
	
}
	public Map<Product, Integer> getCart() {
		return cart;
	}

	public void deleteProduct(Product product) {
		if (cart.containsKey(product)) {
			int qnt = cart.get(product);
			if(qnt!=1) {
			qnt--;
			cart.put(product, qnt);
			}else {
				cart.remove(product);
			}
		}
	}
	public void deleteProductAll(Product product) {
		cart.remove(product);
		
	}
	public void add(String a,Product product) {
		switch(a) {
		case "1":
			addProduct(product);
			System.out.println("add product"+cart.get(product));
			break;
		case"0":	
			deleteProduct(product);
			break;
		}
	}

}
