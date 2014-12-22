package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

public class FilterDB extends Controller {
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

	public static Result getProductByProdTypeAndRating(int page_num,
			int prod_type, int color_id) throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start=12*(page_num-1)+1,end=12*page_num;
		
		String stmt = "CREATE OR REPLACE  FUNCTION RecoByProdType(prod_type1 integer,color_id1 integer ) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "+
" select * from (select  row_number() over() as rn,* from"+ 
" ("+
 " select others.pid as pr_id,others.merchant_name as merchant_name,"+
" others.price as price,others.rating as rating,im.image as image from images im inner join"+ 
" (select p.id as pid,m.name as merchant_name,p.price as price,p.rating"+ 
" as rating from products p inner join merchant m on p.merchant_id=m.merchant_id"+
 " inner join product_color pc on p.id=pc.product_id where p.type_id="+prod_type+  
 " and pc.color_id="+color_id+" order by p.rating desc limit "+12*page_num+") as others on im.id=others.pid order by others.rating desc)"+
 "as temp)as temp1"+
 " where temp1.rn>="+start+" and temp1.rn<="+end
				+ "; end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByProdType(?,?)}");

			cstmt.setInt(1, prod_type); // The name argument is the second ?
			cstmt.setInt(2, color_id); // The name argument is the second ?
			cstmt.execute();

			ResultSet set = ((ResultSet) cstmt.getResultSet());
			int i = 1;
			List<Product> prodList = new ArrayList<Product>();
			while (set.next()) {
				byte[] b = set.getBytes("image");
				Product product = new Product(set.getInt("id"),
						set.getFloat("price"), set.getFloat("rating"),
						new String(Base64.encodeBase64(b)),
						set.getString("merchant_name"));
				System.out.println(i++ + product.toString());
				prodList.add(product);
			}

			cstmt.close();

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
		
		FilterDB.getProductByProdTypeAndRating(1,1,1);
		FilterDB.getProductByProdTypeAndRating(2,1,1);
		FilterDB.getProductByProdTypeAndRating(3,1,1);
	}

}
