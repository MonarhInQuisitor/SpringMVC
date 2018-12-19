package controllers;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;






public class LoginController {
	Statement st;
	User user= new User();
	public String SALT="apple";
	public String getHash(String password) {
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(password));
	return String.format("%032x",new BigInteger(md5.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	public LoginController(Statement st) {
		this.st = st;
	}



	public User checkUser(String login, String password){
		
		String sql="SELECT * FROM  users";
	ResultSet rs=null;
	try {
		rs = st.executeQuery(sql);
		while(rs.next()){
			if((rs.getString("login").equals(login)&&rs.getString("password").equals(getHash(password+SALT)))) {
			user.setName(rs.getString("name"));
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setRegion(rs.getString("region"));
			user.setComment(rs.getString("comment"));
			return user;
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;


	}
	public User getUser() {
		return user;
	}



//	public Product getProductById(int id){
//		String sql="SELECT * FROM  products WHERE id="+id;
//	ResultSet rs=null;
//	try {
//		rs = st.executeQuery(sql);
//		if(rs.next()){
//			Product product=new Product();
//			product.setId(id);
//			product.setName(rs.getString("name"));
//			product.setDescription(rs.getString("description"));
//			product.setCategory(rs.getInt("category"));
//			product.setPrice(rs.getInt("price"));
//			return product;
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return null;
//
//
//	}
}
