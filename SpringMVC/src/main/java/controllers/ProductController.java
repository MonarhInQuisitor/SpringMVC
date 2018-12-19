package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.Product;



public class ProductController {
private Statement st;
private Connection conn;
public ProductController(Statement st) {
	this.st = st;
}

public ProductController(Statement st, Connection conn) {
	this.st = st;
	this.conn = conn;
}

public List<Product> getProducts(){
	String sql="SELECT * FROM  products";
ResultSet rs=null;
List<Product> products=new ArrayList<>();
try {
	rs = st.executeQuery(sql);
	while(rs.next()){
		Product product=new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setCategory(rs.getInt("category"));
		product.setPrice(rs.getInt("price"));
		products.add(product);
	}
	System.out.println("pc0");
	return products;
} catch (SQLException e) {
	e.printStackTrace();
}
return null;


}
public List<Product> getProducts( int category){
	String sql="SELECT * FROM  products WHERE category="+category;
ResultSet rs=null;
List<Product> products=new ArrayList<>();
try {
	rs = st.executeQuery(sql);
	while(rs.next()){
		Product product=new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description").substring(0, 101)+"...");
		product.setCategory(category);
		product.setPrice(rs.getInt("price"));
		products.add(product);
	}
	System.out.println("pc0");
	return products;
} catch (SQLException e) {
	e.printStackTrace();
}
return null;


}
public List<Product> getProductsCategory(int prod){
	switch(prod) {
	case  1:
		return getProducts(prod);
	case 2:
		return getProducts(prod);

	case 3:
		return getProducts(prod);

	}
	
	
	
	return null;

}

public String getCategory(int prod){
	switch(prod) {
case  1:
	return "Наушники Беспроводные";
case 2:
	return"Наушники Проводные";

case 3:
	return "Наушники проводные-беспроводные";

}
	return null;
	
	
}


public Product getProductById(int id){
	String sql="SELECT * FROM  products WHERE id="+id;
ResultSet rs=null;
try {
	rs = st.executeQuery(sql);
	if(rs.next()){
		Product product=new Product();
		product.setId(id);
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setCategory(rs.getInt("category"));
		product.setPrice(rs.getInt("price"));
		return product;
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return null;


}
public boolean add(Product product) {
	System.out.println("controller 1");
	String sql = "INSERT INTO `products` (`name`,`price`,`description`,`category`)"
			+ " VALUES(?,?,?,?)";
	try {
		System.out.println("controller 2");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString( 1, product.getName());
		ps.setInt(2, product.getPrice());
		ps.setString(3, product.getDescription());
		ps.setInt(4, product.getCategory());
		
		return ps.execute();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public void req(String name,String price,String description,String category) {
	Product product = new Product();
	product.setCategory( Integer.parseInt(category));
	product.setName( name);
	product.setPrice( Integer.parseInt( price));
	product.setDescription(description);
	System.out.println(product.toString());
	if(add( product)==false) {
		System.out.println("false");
	}else {
		System.out.println("true");
	}
	
}

}
