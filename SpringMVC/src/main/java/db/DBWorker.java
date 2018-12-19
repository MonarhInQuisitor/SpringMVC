package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWorker {
	private Connection conn;
	private Statement st;
public DBWorker(){
	 try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn =DriverManager.getConnection("jdbc:mysql://localhost/qwert?" +
        	                                   "user=root&password=");
	 st=conn.createStatement();
	 System.out.println("Statement obtained...");
	 } catch (Exception ex) {
         // handle the error
     }
}
public Statement getSt() {
	return st;
}
public Connection getConn() {
	return conn;
}

}
