package controllers;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import models.User;

public class RegistrationController {
	Statement st;
	Connection conn;
	public String SALT = "apple";

	public RegistrationController(Statement st, Connection conn) {
		this.st = st;
		this.conn = conn;
	}

	public String getHash(String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(password));
			return String.format("%032x", new BigInteger(md5.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	public User setUser(String login,String password,String password1,String radio,String region,String textarea,String name) {
		User user = new User();
		user.setName(name);
		user.setLogin(login);
		user.setPassword(password);
		user.setPassword1(password1);
		user.setGender(radio);
		user.setRegion(region);
		user.setComment(textarea);
		return user;
	}

	public boolean checkRegistr(User user) {
		int count = 0;
		if (user.getLogin() != null) {
			if (user.getLogin().length() == 0) {
//				  err=true;
//					errort+="<li>Empty login</li>";
			} else {
				count++;
			}
			if (user.getPassword().length() == 0 || user.getPassword1().length() == 0
					|| user.getPassword().equals(user.getPassword1()) == false) {
//				  	err=true;
//					errort+="<li>Empty password</li>";
			} else {
				count++;
			}
			if (user.getName().length() == 0) {
//				  	err=true;
//					errort+="<li>Empty name</li>";
			} else {
				count++;
			}
		}
		if (count == 3) {
			return true;
		}
		return false;
	}

	public boolean register(User user) {
		System.out.println("controller 1");
		String sql = "INSERT INTO `users` (`name`,`login`,`password`,`gender`,`region`,`comment`)"
				+ " VALUES(?,?,?,?,?,?)";
		try {
			System.out.println("controller 2");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getLogin());
			ps.setString(3, getHash(user.getPassword() + SALT));
			ps.setString(4, user.getGender());
			ps.setString(5, user.getRegion());
			ps.setString(6, user.getComment());
			System.out.println("controller 3");
			return ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void update(User user) {
		String sql = "SELECT * FROM users";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if ((rs.getString("login").equals(user.getLogin()))) {
//					String sqll="UPDATE users SET name = 'asdasdff',login = 's',password = '123',gender = 'we' ,region ='asdf ',comment = 'asdf' WHERE login = 's'";
					String sqll = "UPDATE users SET name = '" + user.getName() + "',password = '" + user.getPassword()
							+ "',gender = '" + user.getGender() + "',region = '" + user.getRegion() + "',comment = '"
							+ user.getComment() + "'  WHERE login = '" + user.getLogin() + "'";
					try {
						PreparedStatement ps = conn.prepareStatement(sqll);
						ps.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public User returnDBUSer(String login) {
		
User user= new User();
		String sql="SELECT * FROM users";
		try {
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				if((rs.getString("login").equals(login))) {
					user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPassword1(rs.getString("password1"));
				user.setGender(rs.getString("gender"));
				user.setComment(rs.getString("comment"));
				user.setRegion(rs.getString("region"));
					break;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return user;
	}
}
