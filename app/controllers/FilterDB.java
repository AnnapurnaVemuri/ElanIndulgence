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
import views.html.productlist;
import views.html.userproductlist;

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

	public static Result getProductByProdTypeAndRatingWithoutColor(
			int prod_type, int page_num) throws Exception {
		List<Product> prodList = new ArrayList<Product>();
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByProdTypeWOC(prod_type1 integer ) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ " select * from (select  row_number() over() as rn,* from"
				+ " ("
				+ " select others.pid as pr_id,others.merchant_name as merchant_name,"
				+ " others.price as price,others.rating as rating,im.image as image from images im inner join"
				+ " (select p.id as pid,m.name as merchant_name,p.price as price,p.rating"
				+ " as rating from products p inner join merchant m on p.merchant_id=m.merchant_id"
				+ " where p.type_id="
				+ prod_type
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ ") as others on im.id=others.pid order by others.rating desc)"
				+ "as temp)as temp1"
				+ " where temp1.rn>="
				+ start
				+ " and temp1.rn<="
				+ end
				+ "; end $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByProdTypeWOC(?)}");

			cstmt.setInt(1, prod_type); // The name argument is the second ?
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
		return ok(productlist.render(prodList));
	}
	
	public static Result getProductByProdTypeAndRatingWithUserName(
			int page_num, int prod_type, String username) throws Exception {

		Connection conn = initializeConnection();
		String stmt = "select color_id from user_prefs where user_name='"
				+ username + "'";
		Statement statement = null;
		ResultSet rs = null;

		statement = conn.createStatement();
		rs = statement.executeQuery(stmt);
		List<Integer> list = new ArrayList<Integer>();
		while (rs.next()) {
			list.add(rs.getInt("color_id"));
		}
		List<Product> rlist=null;
		if (list.size() == 0) {
			rlist=FilterDBReturnList.getProductByProdTypeAndRatingWithoutColor(prod_type, page_num);
		} else {
			rlist=FilterDBReturnList.getProductByProdTypeAndRatingWithColor(page_num, prod_type, list);
		}
		return ok( userproductlist.render(username,rlist));

	}

	public static Result getProductByMerchTypeAndRatingWithUserName(
			int page_num, String merch, String username) throws Exception {

		Connection conn = initializeConnection();
		String stmt = "select color_id from user_prefs where user_name='"
				+ username + "'";
		Statement statement = null;
		ResultSet rs = null;

		statement = conn.createStatement();
		rs = statement.executeQuery(stmt);
		List<Integer> list = new ArrayList<Integer>();
		while (rs.next()) {
			list.add(rs.getInt("color_id"));
		}
		List<String> merchant = new ArrayList<String>();
		merchant.add(merch);
		List<Integer> dummy=new ArrayList<Integer>();
		List<Combo> dummyc=new ArrayList<Combo>();
		List<Product> rlist=null;
		if (list.size() == 0) {
			rlist=getProductByCompleteWithoutColor(page_num, dummy, merchant, dummyc,
					dummy);
		} else {
			rlist=FilterDBReturnList.getProductByForSideFilterWithColour(page_num, dummy, merchant,list,
					dummyc,dummy);
		}
		return ok();

	}

	public static Result getProductByProdTypeAndRatingWithColor(int page_num,
			int prod_type, List<Integer> color) throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;

		String ctype = "";
		ctype += color.get(0);
		for (int i = 1; i < color.size(); i++)
			ctype += "," + color.get(i);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByProdType(prod_type1 integer,color_id1 integer ) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ " select * from (select  row_number() over() as rn,* from"
				+ " ("
				+ " select others.pid as pr_id,others.merchant_name as merchant_name,"
				+ " others.price as price,others.rating as rating,im.image as image from images im inner join"
				+ " (select p.id as pid,m.name as merchant_name,p.price as price,p.rating"
				+ " as rating from products p inner join merchant m on p.merchant_id=m.merchant_id"
				+ " inner join product_color pc on p.id=pc.product_id where p.type_id="
				+ prod_type
				+ " and pc.color_id IN("
				+ ctype
				+ ") order by p.rating desc limit "
				+ 12
				* page_num
				+ ") as others on im.id=others.pid order by others.rating desc)"
				+ "as temp)as temp1"
				+ " where temp1.rn>="
				+ start
				+ " and temp1.rn<="
				+ end
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
			cstmt.setInt(2, 0); // The name argument is the second ?
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

	
	
	
	public static class Combo {
		public Combo(Integer begin, Integer end) {
			super();
			this.begin = begin;
			this.end = end;
		}

		public Integer begin;
		public Integer end;
	}
	
	public static Result getAllProductsWithoutColorWithResult(int page_num,
			List<Integer> prod_type, List<Integer> merchant, List<Combo> price,
			List<Integer> rating)// , List<Integer> merchant, List<Combo>
									// price,List<Integer> rating)
			throws Exception {
		List<Product> prodList = new ArrayList<Product>();
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;
		boolean where = false;
		String ptype = "";
		if (prod_type.size() > 0) {
			where = true;
			ptype += prod_type.get(0);
			for (int i = 1; i < prod_type.size(); i++)
				ptype += "," + prod_type.get(i);
			ptype += ")";
		}
		if (!ptype.equals(""))
			ptype = " p.type_id IN (" + ptype;
		String mtype = "";
		if (merchant.size() > 0) {
			where = true;
			mtype += merchant.get(0);
			for (int i = 1; i < merchant.size(); i++)
				mtype += "," + merchant.get(i);
			mtype += ")";
		}
		if (!mtype.equals(""))
			mtype = " p.merchant_id IN (" + mtype;
		if (!ptype.equals("") && !mtype.equals(""))
			mtype = " and" + mtype;

		String priceq = "";
		if (price.size() > 0) {
			where = true;
			priceq += " (p.price BETWEEN " + price.get(0).begin + " AND "
					+ price.get(0).end + ")";
		}
		for (int i = 1; i < price.size(); i++) {
			priceq += " or ";
			priceq += " (p.price BETWEEN " + price.get(i).begin + " AND "
					+ price.get(i).end + ")";
		}
		if (!priceq.equals(""))
			priceq = "(" + priceq + ")";
		if (!mtype.equals("") && !priceq.equals(""))
			priceq = " and" + priceq;
		System.out.println(priceq);
		String ratingq = "";
		if (rating.size() > 0) {
			where = true;
			ratingq += "(p.rating >= " + rating.get(0) + ")";
		}
		for (int i = 1; i < rating.size(); i++) {
			ratingq += " or ";
			ratingq += "(p.rating >=" + rating.get(i) + ")";
		}
		if (!ratingq.equals(""))
			ratingq = "(" + ratingq + ")";
		if (!priceq.equals("") && !ratingq.equals(""))
			ratingq = " and" + ratingq;
		System.out.println(ratingq);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByWOC(prod_type1 integer) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),ptype integer,price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ "select * from (select row_number() over() rn,others.id,others.merchant_name,others.ptype,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating,p.type_id as ptype"
				+ "	from products p inner join merchant m on p.merchant_id=m.merchant_id "
				+ (where ? "	where " : "")
				+ ptype
				+ mtype
				+ priceq
				+ ratingq
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ " ) as others on im.id=others.id) as temp where temp.rn>="
				+ start
				+ " and temp.rn<=+"
				+ end
				+ "; end;"
				+ " $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		//
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByWOC(?)}");

			cstmt.setInt(1, 1); // The name argument is the second ?

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

	
	
	public static List<Product> getAllProductsWithoutColor(int page_num,
			List<Integer> prod_type, List<Integer> merchant, List<Combo> price,
			List<Integer> rating)// , List<Integer> merchant, List<Combo>
									// price,List<Integer> rating)
			throws Exception {
		List<Product> prodList = new ArrayList<Product>();
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;
		boolean where = false;
		String ptype = "";
		if (prod_type.size() > 0) {
			where = true;
			ptype += prod_type.get(0);
			for (int i = 1; i < prod_type.size(); i++)
				ptype += "," + prod_type.get(i);
			ptype += ")";
		}
		if (!ptype.equals(""))
			ptype = " p.type_id IN (" + ptype;
		String mtype = "";
		if (merchant.size() > 0) {
			where = true;
			mtype += merchant.get(0);
			for (int i = 1; i < merchant.size(); i++)
				mtype += "," + merchant.get(i);
			mtype += ")";
		}
		if (!mtype.equals(""))
			mtype = " p.merchant_id IN (" + mtype;
		if (!ptype.equals("") && !mtype.equals(""))
			mtype = " and" + mtype;

		String priceq = "";
		if (price.size() > 0) {
			where = true;
			priceq += " (p.price BETWEEN " + price.get(0).begin + " AND "
					+ price.get(0).end + ")";
		}
		for (int i = 1; i < price.size(); i++) {
			priceq += " or ";
			priceq += " (p.price BETWEEN " + price.get(i).begin + " AND "
					+ price.get(i).end + ")";
		}
		if (!priceq.equals(""))
			priceq = "(" + priceq + ")";
		if (!mtype.equals("") && !priceq.equals(""))
			priceq = " and" + priceq;
		System.out.println(priceq);
		String ratingq = "";
		if (rating.size() > 0) {
			where = true;
			ratingq += "(p.rating >= " + rating.get(0) + ")";
		}
		for (int i = 1; i < rating.size(); i++) {
			ratingq += " or ";
			ratingq += "(p.rating >=" + rating.get(i) + ")";
		}
		if (!ratingq.equals(""))
			ratingq = "(" + ratingq + ")";
		if (!priceq.equals("") && !ratingq.equals(""))
			ratingq = " and" + ratingq;
		System.out.println(ratingq);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByWOC(prod_type1 integer) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),ptype integer,price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ "select * from (select row_number() over() rn,others.id,others.merchant_name,others.ptype,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating,p.type_id as ptype"
				+ "	from products p inner join merchant m on p.merchant_id=m.merchant_id "
				+ (where ? "	where " : "")
				+ ptype
				+ mtype
				+ priceq
				+ ratingq
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ " ) as others on im.id=others.id) as temp where temp.rn>="
				+ start
				+ " and temp.rn<=+"
				+ end
				+ "; end;"
				+ " $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		//
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByWOC(?)}");

			cstmt.setInt(1, 1); // The name argument is the second ?

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
		return prodList;
	}


	public static List<Product> getProductByCompleteWithoutColor(int page_num,
			List<Integer> prod_type, List<String> merch, List<Combo> price,
			List<Integer> rating)// , List<Integer> merchant, List<Combo>
									// price,List<Integer> rating)
			throws Exception {
		List<Product> prodList = new ArrayList<Product>();
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;
		boolean where = false;
		List<Integer> merchant = new ArrayList<Integer>();
		for (String m : merch) {
			String merch_st = "select merchant_id from merchant where name='"
					+ m + "'";
			statement = conn.createStatement();
			rs = statement.executeQuery(merch_st);

			while (rs.next()) {
				merchant.add(rs.getInt("merchant_id"));

			}
		}
		String ptype = "";
		if (prod_type.size() > 0) {
			where = true;
			ptype += prod_type.get(0);
			for (int i = 1; i < prod_type.size(); i++)
				ptype += "," + prod_type.get(i);
			ptype += ")";
		}
		if (!ptype.equals(""))
			ptype = " p.type_id IN (" + ptype;
		String mtype = "";
		if (merchant.size() > 0) {
			where = true;
			mtype += merchant.get(0);
			for (int i = 1; i < merchant.size(); i++)
				mtype += "," + merchant.get(i);
			mtype += ")";
		}
		if (!mtype.equals(""))
			mtype = " p.merchant_id IN (" + mtype;
		if (!ptype.equals("") && !mtype.equals(""))
			mtype = " and" + mtype;

		String priceq = "";
		if (price.size() > 0) {
			where = true;
			priceq += " (p.price BETWEEN " + price.get(0).begin + " AND "
					+ price.get(0).end + ")";
		}
		for (int i = 1; i < price.size(); i++) {
			priceq += " or ";
			priceq += " (p.price BETWEEN " + price.get(i).begin + " AND "
					+ price.get(i).end + ")";
		}
		if (!priceq.equals(""))
			priceq = "(" + priceq + ")";
		if (!mtype.equals("") && !priceq.equals(""))
			priceq = " and" + priceq;
		System.out.println(priceq);
		String ratingq = "";
		if (rating.size() > 0) {
			where = true;
			ratingq += "(p.rating >= " + rating.get(0) + ")";
		}
		for (int i = 1; i < rating.size(); i++) {
			ratingq += " or ";
			ratingq += "(p.rating >=" + rating.get(i) + ")";
		}
		if (!ratingq.equals(""))
			ratingq = "(" + ratingq + ")";
		if (!priceq.equals("") && !ratingq.equals(""))
			ratingq = " and" + ratingq;
		System.out.println(ratingq);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByWOC(prod_type1 integer) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),ptype integer,price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ "select * from (select row_number() over() rn,others.id,others.merchant_name,others.ptype,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating,p.type_id as ptype"
				+ "	from products p inner join merchant m on p.merchant_id=m.merchant_id "
				+ (where ? "	where " : "")
				+ ptype
				+ mtype
				+ priceq
				+ ratingq
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ " ) as others on im.id=others.id) as temp where temp.rn>="
				+ start
				+ " and temp.rn<=+"
				+ end
				+ "; end;"
				+ " $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		//
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByWOC(?)}");

			cstmt.setInt(1, 1); // The name argument is the second ?

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
		return prodList;
	}

	
	public static Result getProductByCompleteWithoutColorWithResult(int page_num,
			List<Integer> prod_type, List<String> merch, List<Combo> price,
			List<Integer> rating)// , List<Integer> merchant, List<Combo>
									// price,List<Integer> rating)
			throws Exception {
		List<Product> prodList = new ArrayList<Product>();
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;
		boolean where = false;
		List<Integer> merchant = new ArrayList<Integer>();
		for (String m : merch) {
			String merch_st = "select merchant_id from merchant where name='"
					+ m + "'";
			statement = conn.createStatement();
			rs = statement.executeQuery(merch_st);

			while (rs.next()) {
				merchant.add(rs.getInt("merchant_id"));

			}
		}
		String ptype = "";
		if (prod_type.size() > 0) {
			where = true;
			ptype += prod_type.get(0);
			for (int i = 1; i < prod_type.size(); i++)
				ptype += "," + prod_type.get(i);
			ptype += ")";
		}
		if (!ptype.equals(""))
			ptype = " p.type_id IN (" + ptype;
		String mtype = "";
		if (merchant.size() > 0) {
			where = true;
			mtype += merchant.get(0);
			for (int i = 1; i < merchant.size(); i++)
				mtype += "," + merchant.get(i);
			mtype += ")";
		}
		if (!mtype.equals(""))
			mtype = " p.merchant_id IN (" + mtype;
		if (!ptype.equals("") && !mtype.equals(""))
			mtype = " and" + mtype;

		String priceq = "";
		if (price.size() > 0) {
			where = true;
			priceq += " (p.price BETWEEN " + price.get(0).begin + " AND "
					+ price.get(0).end + ")";
		}
		for (int i = 1; i < price.size(); i++) {
			priceq += " or ";
			priceq += " (p.price BETWEEN " + price.get(i).begin + " AND "
					+ price.get(i).end + ")";
		}
		if (!priceq.equals(""))
			priceq = "(" + priceq + ")";
		if (!mtype.equals("") && !priceq.equals(""))
			priceq = " and" + priceq;
		System.out.println(priceq);
		String ratingq = "";
		if (rating.size() > 0) {
			where = true;
			ratingq += "(p.rating >= " + rating.get(0) + ")";
		}
		for (int i = 1; i < rating.size(); i++) {
			ratingq += " or ";
			ratingq += "(p.rating >=" + rating.get(i) + ")";
		}
		if (!ratingq.equals(""))
			ratingq = "(" + ratingq + ")";
		if (!priceq.equals("") && !ratingq.equals(""))
			ratingq = " and" + ratingq;
		System.out.println(ratingq);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoByWOC(prod_type1 integer) "

				+ " returns TABLE ( rn bigint,id integer,merchant_name character varying(255),ptype integer,price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ "select * from (select row_number() over() rn,others.id,others.merchant_name,others.ptype,others.price,others.rating,im.image from images im inner join (select p.id as id,m.name as merchant_name,p.price as price,p.rating as rating,p.type_id as ptype"
				+ "	from products p inner join merchant m on p.merchant_id=m.merchant_id "
				+ (where ? "	where " : "")
				+ ptype
				+ mtype
				+ priceq
				+ ratingq
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ " ) as others on im.id=others.id) as temp where temp.rn>="
				+ start
				+ " and temp.rn<=+"
				+ end
				+ "; end;"
				+ " $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		//
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoByWOC(?)}");

			cstmt.setInt(1, 1); // The name argument is the second ?

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

	
	
	public static Result getProductByForSideFilterWithColour(int page_num,
			List<Integer> prod_type, List<String> merch, List<Integer> color,
			List<Combo> price, List<Integer> rating)// , List<Integer> merchant,
													// List<Combo>
													// price,List<Integer>
													// rating)
			throws Exception {
		Connection conn = initializeConnection();
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		int start = 12 * (page_num - 1) + 1, end = 12 * page_num;
		boolean where = false;

		List<Integer> merchant = new ArrayList<Integer>();

		for (String m : merch) {
			String merch_st = "select merchant_id from merchant where name='"
					+ m + "'";
			statement = conn.createStatement();
			rs = statement.executeQuery(merch_st);

			while (rs.next()) {
				merchant.add(rs.getInt("merchant_id"));

			}
		}

		String ptype = "";
		if (prod_type.size() > 0) {
			where = true;
			ptype += prod_type.get(0);
			for (int i = 1; i < prod_type.size(); i++)
				ptype += "," + prod_type.get(i);
			ptype += ")";
		}
		if (!ptype.equals(""))
			ptype = " p.type_id IN (" + ptype;
		String mtype = "";
		if (merchant.size() > 0) {
			where = true;
			mtype += merchant.get(0);
			for (int i = 1; i < merchant.size(); i++)
				mtype += "," + merchant.get(i);
			mtype += ")";
		}
		if (!mtype.equals(""))
			mtype = " p.merchant_id IN (" + mtype;
		if (!ptype.equals("") && !mtype.equals(""))
			mtype = " and" + mtype;
		String ctype = "";
		if (color.size() > 0) {
			where = true;
			ctype += color.get(0);
			for (int i = 1; i < color.size(); i++)
				ctype += "," + color.get(i);
			ctype += ")";
		}
		if (!ctype.equals(""))
			ctype = " pc.color_id IN (" + ctype;

		if (!mtype.equals("") && !ctype.equals(""))
			ctype = " and" + ctype;
		String priceq = "";
		if (price.size() > 0) {
			where = true;
			priceq += " (p.price BETWEEN " + price.get(0).begin + " AND "
					+ price.get(0).end + ")";
		}
		for (int i = 1; i < price.size(); i++) {
			priceq += " or ";
			priceq += " (p.price BETWEEN " + price.get(i).begin + " AND "
					+ price.get(i).end + ")";
		}
		if (!priceq.equals(""))
			priceq = "(" + priceq + ")";
		if (!ctype.equals("") && !priceq.equals(""))
			priceq = " and" + priceq;
		System.out.println(priceq);
		String ratingq = "";
		if (rating.size() > 0) {
			where = true;
			ratingq += "(p.rating >= " + rating.get(0) + ")";
		}
		for (int i = 1; i < rating.size(); i++) {
			ratingq += " or ";
			ratingq += "(p.rating >=" + rating.get(i) + ")";
		}
		if (!ratingq.equals(""))
			ratingq = "(" + ratingq + ")";
		if (!priceq.equals("") && !ratingq.equals(""))
			ratingq = " and" + ratingq;
		System.out.println(ratingq);

		String stmt = "CREATE OR REPLACE  FUNCTION RecoBy(prod_type1 integer,color_id1 integer ) "

				+ " returns TABLE ( rn bigint,id integer,color_id integer,merchant_name character varying(255),ptype integer,price double precision,rating double precision,image bytea)  as $$ begin "
				+ " return query "
				+ "select * from (select row_number() over() rn,others.id,others.color_id,others.merchant_name,others.ptype,others.price,others.rating,im.image from images im inner join (select p.id as id,pc.color_id as color_id,m.name as merchant_name,p.price as price,p.rating as rating,p.type_id as ptype"
				+ "	from products p inner join merchant m on p.merchant_id=m.merchant_id inner join product_color pc on p.id=pc.product_id"
				+ (where ? "	where " : "")
				+ ptype
				+ mtype
				+ ctype
				+ priceq
				+ ratingq
				+ " order by p.rating desc limit "
				+ 12
				* page_num
				+ " ) as others on im.id=others.id) as temp where temp.rn>="
				+ start
				+ " and temp.rn<="
				+ end
				+ "; end;"
				+ " $$ LANGUAGE 'plpgsql' IMMUTABLE SECURITY DEFINER COST 10 ";
		System.out.println(stmt);
		// where temp.rn>=1 and temp.rn<=8;
		try {
			connection = conn;

			statement = connection.createStatement();
			statement.execute(stmt);
			statement.close();

			PreparedStatement cstmt = connection
					.prepareCall("{call  RecoBy(?,?)}");

			cstmt.setInt(1, 1); // The name argument is the second ?
			cstmt.setInt(2, 1); // The name argument is the second ?
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
				System.out.println(i++ + product.toString()+" "+set.getString("color_id"));
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
	
		List<Integer> ptype = new ArrayList<Integer>();
		// ptype.add(1);
		// ptype.add(2);
		List<Integer> mtype = new ArrayList<Integer>();
		mtype.add(2);
		mtype.add(3);
		List<Integer> ctype = new ArrayList<Integer>();
		ctype.add(5);
		// ctype.add(7);
		// ctype.add(9);
		Combo c1 = new Combo(30, 40);
		Combo c2 = new Combo(60, 71);
		List<Combo> combo = new ArrayList<Combo>();
		// combo.add(c1);
		// combo.add(c2);
		List<Integer> rtype = new ArrayList<Integer>();
		// rtype.add(0);
		// rtype.add(1);
		//FilterDB.getProductByMerchTypeAndRatingWithUserName(1, "Bhaminee","sowmya1");
		FilterDB.getProductByProdTypeAndRatingWithUserName(1, 1, "sowmya");

}
}
