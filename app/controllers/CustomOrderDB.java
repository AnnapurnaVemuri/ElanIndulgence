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
import models.CustomOrderMessages;
import models.CustomOrders;
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

public class CustomOrderDB extends Controller {
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
		CustomOrders order = Form.form(CustomOrders.class).bindFromRequest().get();
		order.date_created = new Date(new java.util.Date().getTime());
		order.save();
		return ok();
	}
	
	public static Result updateMessageForOrder(){
		CustomOrderMessages order = Form.form(CustomOrderMessages.class).bindFromRequest().get();
		order.date_created = new Date(new java.util.Date().getTime());
		order.save();
		return ok();
	}

	public static Result getCustomOrderForOrderId(int id) {
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		String stmt ="select com.fromCust as fromCust,com.msg_id as msg_id,com.message as message,com.date_created as date_created from CustomOrders co inner join"
				+ " CustomOrderMessages com on co.id=com.order_id where co.id="+id+" order by com.date_created asc";
				
		try {
			connection = initializeConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(stmt);
			List<CustomOrderMessages> orderList = new ArrayList<CustomOrderMessages>();
			while (rs.next()) {
				
				CustomOrderMessages com = new CustomOrderMessages(id,rs.getInt("msg_id"),
						rs.getString("message"),rs.getBoolean("fromCust")
						,rs.getDate("date_created"));
						
				System.out.println(com);
				orderList.add(com);
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
//CustomOrderDB.getOrderForMerchant(2);
CustomOrderDB.getCustomOrderForOrderId(2);
	}

}
