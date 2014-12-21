package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import models.ui.OrderUI;
import models.Orders;
import models.Product;
import models.UserInfo;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DatabaseConstants;
import views.html.main;
import views.html.user;

public class OrderDB extends Controller {
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

	public static Result createNewOrder() {
		Orders order = Form.form(Orders.class).bindFromRequest().get();
		order.date_created = new Date(new java.util.Date().getTime());
		order.save();
		return ok();
	}

	public static Result getOrderForCustomer(int cust_id) {
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		String stmt = "select o.id as order_id,m.name as merch_name,pt.type_name as prod_type,p.quantity as quant,p.date_added as date_created,p.id as prod_id"
				+ " from orders o  inner join products p on p.id=o.prod_id inner join product_type pt on p.type_id=pt.type_id inner join merchant m on p.merchant_id=m.merchant_id where o.cust_id="
				+ cust_id + " order by date_created desc";
		try {
			connection = initializeConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(stmt);
			List<OrderUI> orderList = new ArrayList<OrderUI>();
			while (rs.next()) {
				
				OrderUI order = new OrderUI(rs.getInt("order_id"),
						rs.getString("merch_name"), rs.getInt("prod_id"),rs.getInt("quant")
						,rs.getDate("date_created"),
						rs.getString("prod_type"));
				System.out.println(order);
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
		return ok();
	}

	public static Result getOrderForMerchant(int merch_id) {
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		String stmt = "select o.id as order_id,m.name as merch_name,pt.type_name as prod_type,p.quantity as quant,p.date_added as date_created,p.id as prod_id"
				+ " from orders o  inner join products p on p.id=o.prod_id inner join product_type pt on p.type_id=pt.type_id inner join merchant m on p.merchant_id=m.merchant_id where p.merchant_id="
				+ merch_id + " order by date_created desc";
		try {
			connection = initializeConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(stmt);
			List<OrderUI> orderList = new ArrayList<OrderUI>();
			while (rs.next()) {
				
				OrderUI order = new OrderUI(rs.getInt("order_id"),
						rs.getString("merch_name"), rs.getInt("prod_id"),rs.getInt("quant")
						,rs.getDate("date_created"),
						rs.getString("prod_type"));
				System.out.println(order);
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
		return ok();
	}

	public static void main(String[] args) throws Exception {
OrderDB.getOrderForMerchant(2);
	}

}
