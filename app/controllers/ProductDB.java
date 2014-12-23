package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import models.Product;
import models.ui.OrderUI;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.product;

public class ProductDB extends Controller {

	private static String db_url = "jdbc:postgresql://cloudproj.ct233hyipvfx.us-east-1.rds.amazonaws.com:5432/elandb";
	private static String username = "elan";
	private static String password = "Indulgence";

	private static Connection initializeConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Connection conn = null;
		try {
			while (conn == null) {
				conn = DriverManager.getConnection(db_url, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Product getProd(int prod_id) {
		Statement statement = null;
		ResultSet set = null;
		Connection connection = null;
		String stmt=" select others.id as id,others.merchant_name as merchant_name,"
				+" others.price as price,others.rating as rating,im.image as image from images im inner join" 
				+" (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+" from products p inner join merchant m on p.merchant_id=m.merchant_id where p.id="+prod_id
				+" order by p.date_added ) as others on im.id=others.id;";
					
		Product prod=null;	
		try {
			connection = initializeConnection();
			statement = connection.createStatement();
			set = statement.executeQuery(stmt);
			
			while (set.next()) {
				byte[] b = set.getBytes("image");
				prod = new Product(set.getInt("id"),
						set.getFloat("price"), set.getFloat("rating"),
						new String(Base64.encodeBase64(b)),
						set.getString("merchant_name"));
				System.out.println(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return prod;
	}

	public static Product getProdType(int prod_id) {
		Statement statement = null;
		ResultSet set = null;
		Connection connection = null;
		String stmt="select p.type_id as type_id,p.merchant_id as merch_id,m.name as merch_name from products p inner join merchant m on p.merchant_id=m.merchant_id where p.id="+prod_id;
		Integer prod_type=null,merch_type=null;
		String merch_name="";
		try {
			connection = initializeConnection();
			statement = connection.createStatement();
			set = statement.executeQuery(stmt);
			set.next();
			prod_type=set.getInt("type_id");
			merch_type=set.getInt("merch_id");
			merch_name=set.getString("merch_name");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		Product prod=new Product();
		prod.prod_type=prod_type;
		prod.merchant=merch_name;
		prod.merch_id=merch_type;
				
		return prod;
	}
	public static void main(String[] args){
		ProductDB pdb=new ProductDB();
		Product p=ProductDB.getProdType(15);
		System.out.println(p.merch_id+" "+p.merchant+" "+p.prod_type);
	}

	
	
}
