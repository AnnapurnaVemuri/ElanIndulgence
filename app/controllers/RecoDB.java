package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import views.html.*;

import org.apache.commons.codec.binary.Base64;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

public class RecoDB extends Controller {
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

	private static Result getProductByMerchantAndRating(int prod_type,
			String merch) throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		String merch_st="select merchant_id from merchant where name='"+merch+"'";		
		statement = conn.createStatement();
		rs = statement.executeQuery(merch_st);
		 
		rs.next();
		int merchant_type=rs.getInt("merchant_id");

		

		
		Connection connection = null;
		String stmt = "CREATE OR REPLACE  FUNCTION RecoByMerchantWithoutColor(prod_type1 integer,merchant_id1 integer ) "

				+ " returns TABLE (id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query select others.id,others.merchant_name,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id "
				+ " where p.type_id=prod_type1 and  p.merchant_id=merchant_id1 order by p.rating desc limit 6) as others on im.id=others.id;"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByMerchantWithoutColor(?,?)}");

			cstmt.setInt(1, prod_type); // The name argument is the second ?
			cstmt.setInt(2, merchant_type); // The raise argument is the third ?
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

	public static Result getProductByRating(int prod_type)
			throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		String stmt = "CREATE OR REPLACE  FUNCTION RecoForProductWithoutColor(prod_type1 integer) "

				+ " returns TABLE (id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query select others.id,others.merchant_name,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id"
				+ " where p.type_id=prod_type1  order by p.rating desc limit 12) as others on im.id=others.id;"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoForProductWithoutColor(?)}");

			cstmt.setInt(1, prod_type); // The name argument is the second ?
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

	
	private static Result getProductByMerchantAndRatingWithColor(int prod_type,
			String merch, int color_id) throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		
		String merch_st="select merchant_id from merchant where name='"+merch+"'";		
		statement = conn.createStatement();
		rs = statement.executeQuery(merch_st);
		 
		rs.next();
		int merchant_type=rs.getInt("merchant_id");


		
		Connection connection = null;
		String stmt = "CREATE OR REPLACE  FUNCTION RecoByMerchant(prod_type1 integer,merchant_id1 integer,color_id1 integer ) "

				+ " returns TABLE (id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query select others.id,others.merchant_name,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id inner join product_color pc on p.id=pc.product_id"
				+ " where p.type_id=prod_type1 and  p.merchant_id=merchant_id1 and pc.color_id=color_id1 order by p.rating desc limit 6) as others on im.id=others.id;"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByMerchant(?,?,?)}");

			cstmt.setInt(1, prod_type); // The name argument is the second ?
			cstmt.setInt(2, merchant_type); // The raise argument is the third ?
			cstmt.setInt(3, color_id); // The name argument is the second ?
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

	private static Result getProductByRatingWithColor(int prod_type, int color_id)
			throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		String stmt = "CREATE OR REPLACE  FUNCTION RecoForProduct(prod_type1 integer,color_id1 integer ) "

				+ " returns TABLE (id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query select others.id,others.merchant_name,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id inner join product_color pc on p.id=pc.product_id"
				+ " where p.type_id=prod_type1 and pc.color_id=color_id1 order by p.rating desc limit 12) as others on im.id=others.id;"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoForProduct(?,?)}");

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
	
	public static Result getLatestProductsForUser(int page_num, String u) {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		List<Product> products = new ArrayList<Product>();
		int start=12*(page_num-1)+1,end=12*page_num;
		String stmt = " CREATE OR REPLACE  FUNCTION NewArrivals()"
				+ " returns TABLE (rn bigint,id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin"
				+ " return query select * from( select row_number() over() as rn,others.id as id,others.merchant_name as merchant_name,others.price as price,others.rating as rating,im.image as image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id"
				+ " order by p.date_added desc limit "+12*page_num+") as others on im.id=others.id) as temp where temp.rn>="+start+" and temp.rn<="+end+";"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10;";

		try {
			connection = conn;
			statement = connection.createStatement();

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  NewArrivals()}");

			cstmt.execute();

			ResultSet set = ((ResultSet) cstmt.getResultSet());
			int i = 1;
			while (set.next()) {
				byte[] b = set.getBytes("image");
				Product product = new Product(set.getInt("id"),
						set.getFloat("price"), set.getFloat("rating"),
						new String(Base64.encodeBase64(b)),
						set.getString("merchant_name"));
				System.out.println(i++ + product.toString());
				products.add(product);
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
		return ok(userproductlist.render(u, products));
	}

	public static Result getLatestProducts(int page_num) throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		List<Product> products = new ArrayList<Product>();
		int start=12*(page_num-1)+1,end=12*page_num;
		String stmt = " CREATE OR REPLACE  FUNCTION NewArrivals()"
				+ " returns TABLE (rn bigint,id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin"
				+ " return query select * from( select row_number() over() as rn,others.id as id,others.merchant_name as merchant_name,others.price as price,others.rating as rating,im.image as image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating"
				+ " from products p inner join merchant m on p.merchant_id=m.merchant_id"
				+ " order by p.date_added desc limit "+12*page_num+") as others on im.id=others.id) as temp where temp.rn>="+start+" and temp.rn<="+end+";"
				+ " end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10;";

		try {
			connection = conn;
			statement = connection.createStatement();

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  NewArrivals()}");

			cstmt.execute();

			ResultSet set = ((ResultSet) cstmt.getResultSet());
			int i = 1;
			while (set.next()) {
				byte[] b = set.getBytes("image");
				Product product = new Product(set.getInt("id"),
						set.getFloat("price"), set.getFloat("rating"),
						new String(Base64.encodeBase64(b)),
						set.getString("merchant_name"));
				System.out.println(i++ + product.toString());
				products.add(product);
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
		return ok(productlist.render(products));
	}

	public static void main(String[] args) throws Exception {
		RecoDB r = new RecoDB();
	//	 RecoDB.getProductByRatingWithColor(1, 1);
		 RecoDB.getProductByMerchantAndRatingWithColor(1, "Bhaminee", 1);
		//RecoDB.getLatestProducts(2);
		RecoDB.getProductByMerchantAndRating(1,"Bhaminee");
		//RecoDB.getProductByRating(1);
	}

}
