package controllers;

import models.CustomOrderMessages;
import models.CustomizedOrders;
import models.Merchant;
import models.Product;
import models.UserInfo;
import play.data.Form;
import play.db.DB;
import play.mvc.*;
import utils.DatabaseConstants;
import utils.UserPref;
import views.html.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.ExpressionList;

import controllers.FilterDB.Combo;

public class Application extends Controller {

    public static Result loadMain() {
        return ok(main.render("ElanIndulgence", ""));
    }
    
    public static Result registerUser() {
    	UserInfo info = Form.form(UserInfo.class).bindFromRequest().get();
    	info.save();
    	return checkUserExist(info.username, info.password, true);
    }
    
    public static Result loginValidation() {
    	UserInfo info = Form.form(UserInfo.class).bindFromRequest().get();
    	return checkUserExist(info.username, info.password, false);
    }
    
    public static Result getUser(String username, String newReq) {
    	List<CustomizedOrders> allorder = CustomizedOrders.findInvolving(username);
    	for (CustomizedOrders order: allorder) {
    		List<CustomOrderMessages> messages = CustomOrderMessages.findByID(order.id);
    		if (messages != null) {
	    		for (CustomOrderMessages message : messages) {
	    			order.messages.add(message);
	    		}
    		}
    	}
    	return ok(user.render(username, newReq, "FALSE", allorder));
    }
    
    public static Result addCustomOrder() {
    	System.out.println("Got custom order");
    	CustomizedOrders order = Form.form(CustomizedOrders.class).bindFromRequest().get();
    	System.out.println(order.custusername);
    	System.out.println(order.merchantname);
    	System.out.println(order.budgetrange);
    	System.out.println(order.description);
    	System.out.println(order.prodtype);
    	System.out.println(order.prefcolors);
    	StringBuilder builder = new StringBuilder();
    	for (int i = 0; i < order.prefcolors.size(); i++) {
    		if(order.prefcolors.get(i) != null) {
        		builder.append(order.prefcolors.get(i));
        		builder.append(",");
    		}
    	}
    	order.colorsList = builder.toString();
    	System.out.println(order.colorsList);
    	order.save();
    	List<CustomizedOrders> allorder = CustomizedOrders.findInvolving(order.custusername);
    	for (CustomizedOrders order1: allorder) {
    		List<CustomOrderMessages> messages = CustomOrderMessages.findByID(order.id);
    		if (messages != null) {
	    		for (CustomOrderMessages message : messages) {
	    			order1.messages.add(message);
	    		}
    		}
    	}
    	return ok(user.render(order.custusername, "FALSE", "TRUE", allorder));
    }
    
    public static Result getAllOrdersOfUser(String username) {
    	List<CustomizedOrders> allorder = CustomizedOrders.findInvolving(username);
    	for (CustomizedOrders order: allorder) {
    		List<CustomOrderMessages> messages = CustomOrderMessages.findByID(order.id);
    		if (messages != null) {
	    		for (CustomOrderMessages message : messages) {
	    			order.messages.add(message);
	    		}
    		}
    	}
    	return ok(user.render(username, "FALSE", "TRUE", allorder));
    }
    
    private static Result checkUserExist(String username, String password, boolean isRegister) {
    	Statement statement = null;
    	ResultSet rs = null;
    	Connection connection = null;
    	String stmt = "select * from " + DatabaseConstants.USER_INFO_TABLE + " where username = '" + username + "' and password = '" + password + "'";
    	try {
    		connection = DB.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(stmt);
			if (rs.next()) {
				if (isRegister) {
					return redirect(controllers.routes.Application.getUser(username, "TRUE"));
				} else {
					return redirect(controllers.routes.Application.getUser(username, "FALSE"));
				}
			} else {
				return ok(main.render("ElanIndulgence", "Incorrect Username and Password Combination"));
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
    
    public static Result saveUserPreferences() {
    	UserPref pref = Form.form(UserPref.class).bindFromRequest().get();
    	System.out.println(pref.username);
    	for (Integer i : pref.prefList) {
    		System.out.println(pref.prefList.get(i));
    	}
    	return ok("Saving user preferences");
    }
    
    public static Result merchantValidation() {
    	Merchant info = Form.form(Merchant.class).bindFromRequest().get();
    	return checkMerchantExist(info.username, info.password, false);
    }
    
    public static Result registerMerchant() {
    	Merchant info = Form.form(Merchant.class).bindFromRequest().get();
    	info.save();
    	return checkMerchantExist(info.username, info.password, true);
    }
    
    public static Result getProductsOfMerchant(int merchant_id, int page_num) {
    	List<Integer> merchantList = new ArrayList<Integer>();
    	merchantList.add(merchant_id);
    	List<Integer> prodType = new ArrayList<Integer>();
    	List<Combo> price = new ArrayList<Combo>();
    	List<Integer> rating = new ArrayList<Integer>();
    	List<Product> prods = new ArrayList<Product>();
    	List<Product> recos = new ArrayList<Product>();
    	try {
			prods = FilterDB.getAllProductsWithoutColor(page_num, prodType, merchantList, price, rating);
			recos=RecoDB.getLatestProductsList(page_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ok(productlist.render(prods,recos));
    }
    
    public static Result getProductsOfMerchantWithUname(int merchant_id,String uname, int page_num) {
    	List<Product> prods = new ArrayList<Product>();
    	List<Product> recos = new ArrayList<Product>();
    	try {
			prods = FilterDB.getProductByMerchIDAndRatingWithUserName(page_num, merchant_id,uname);
			recos=RecoDB.getLatestProductsForUserList(page_num, uname);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return ok(userproductlist.render(uname,prods,recos));
    }
    
    
    
    public static Result getMerchant(String user, int page_num) {
    	List<Integer> merchantList = new ArrayList<Integer>();
    	merchantList.add(1);
    	List<Integer> prodType = new ArrayList<Integer>();
    	List<Combo> price = new ArrayList<Combo>();
    	List<Integer> rating = new ArrayList<Integer>();
    	List<Product> prods = new ArrayList<Product>();
    	try {
        	prods = FilterDB.getAllProductsWithoutColor(page_num, prodType, merchantList, price, rating);	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	List<Merchant> merchants = Merchant.findInvolving(user);
    	System.out.println("For merchant username=" + user);
    	System.out.println("got matches:" + merchants.size());
    	List<CustomizedOrders> allorder = null;
    	
    	if (merchants.size() > 0) {
    		Merchant merchant = merchants.get(0);
        	System.out.println("got merchant with name:"+ merchant.name);
    		allorder = CustomizedOrders.findUsingMerchantName(merchant.name);
    		for (CustomizedOrders order: allorder) {
        		List<CustomOrderMessages> messages = CustomOrderMessages.findByID(order.id);
        		if (messages != null) {
    	    		for (CustomOrderMessages message : messages) {
    	    			order.messages.add(message);
    	    		}
        		}
        	}
    	}
    	return ok(merchant.render(user, prods, allorder));
    }
    
    public static Result addMessageToOrder() {
    	CustomOrderMessages info = Form.form(CustomOrderMessages.class).bindFromRequest().get();
    	info.date_created = new Date();
    	info.save();
    	List<CustomizedOrders> orders = CustomizedOrders.findUsingId(info.order_id);
    	CustomizedOrders order = new CustomizedOrders();
    	if (orders.size() > 0) {
    		order = orders.get(0);
    	}
    	if (info.fromCust) {
    		return getAllOrdersOfUser(order.custusername);
    	} else {
    		List<Merchant> merchants = Merchant.findUsingName(order.merchantname);
    		Merchant m = new Merchant();
    		if (merchants.size() > 0) {
    			m = merchants.get(0);
    		}
    		return redirect(controllers.routes.Application.getMerchant(m.username, 1));
    	}
    }
    
    private static Result checkMerchantExist(String username, String password, boolean isRegister) {
    	Statement statement = null;
    	ResultSet rs = null;
    	Connection connection = null;
    	System.out.println("username:" + username);
    	String stmt = "select * from " + DatabaseConstants.MERCHANT_TABLE + " where username = '" + username + "' and password = '" + password + "'";
    	try {
    		connection = DB.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(stmt);
			if (rs.next()) {
				if (isRegister) {
					return redirect(controllers.routes.Application.getMerchant(username,1));
				} else {
					return redirect(controllers.routes.Application.getMerchant(username,1));
				}
			} else {
				return ok(main.render("ElanIndulgence", "Incorrect Username and Password Combination"));
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

    public static Result loadProduct(String p) throws Exception {
    	int p_id = Integer.parseInt(p);
    	Connection connection = DB.getConnection();
    	Product prod=ProductDB.getProd(p_id);
    	Product prod2=ProductDB.getProdType(p_id);
    	List<Product> finlist=RecoDB.getCombinedRecoWithUserName("",prod2.prod_type,prod2.merchant);
    	//Product prod = new Product(p_id, 91.3f, 3.4f, "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4OrmkHbKOtxqXlM9NzBKPKVAxagvEqpotx6SnuXMH+BLZ1/V4PDixeEKr1zGwCvowBrK/iCLXM7NDUdtCjl4lbD1CarTKl3LecsFxwFNHwafYyH+wgVFMeges5k7dZh0IPrPPNV1gW0GkG62S7nOCRcINDasoXsNdjwa9LD0jcBe52x5ISrxVrbZvtL69k4A2VinZ6Ny1cCXUYc2ypwsX68/CZecgASdGseUciPKWd+RZ2zwHLO4Cfb6sVG3jGenkx1q8gMoSpkDLdb3HhPgTQ6N5Llgnk/h+Iw2rcflMnj75/eP5AbpUPH8ygoO1RypIJFlL9O1+EdJ2jqVf5AmbD0V8+soDeuCdSdk1z4QSpIuJXL0/R/yfumUBBq+JlJB3d34IsG37hirhe3UOXrMI51UysAecDR2vVz/AMmAdgdn/kMst8K327+BxxdtPIjnpCVP2uAAQoBFIGVWxD+TGw8+s0EwCj/KtUS8uH2m6LOdGIXBLYcjjHM7w4KnWCJZk/3oBHIxW+It4QuNux2av9Au/sDGbBOPp69e0MTRGy8TJCeDSWoOesJ6mPFpEDgXLLd6A+kpjdWUACjB/wCN/9oADAMBAAIAAwAAABDzzzzzzzrrzzzzzzzzzzzwOzFfzzzzzzzzzzwJQczzzzzzzzzzzxKa+7zzzzzzzzzzyz/Bnzzzzzzzzzxzitz6DzzzzzzzznKtJWFzTzzzzzz1o9NeuAwbzzzzzy9mqZX1SC/zzzzzzy3UQ12j1/zzzzzzzztHQNl3zzzzzzzzwBPMiHfzzzzzzzzyF2wfOjzzzzzzzzyWKmbp/wA88888888dmSN3W888888888ZdRs6Z888888888H34H1o888888888krmqNl888888888/X/bi3888888888aV88E288888886wj/88p60888888sv8888LT0888888888888888888//EACcRAQACAQMDAwUBAQAAAAAAAAEAESEwMUFRYfBxgbEQIJHB4UDR/9oACAEDAQE/EPvqswb1aGWB2JZ4cQbL1BQI1eEA95TZcagk5PiF3YB1JQNzd1A8AghJSo3dibYrS3jAVF3rs8+stUzyc+0FGo5xywd16R+q/wBesMhxnz20UV9omo8sr9QRDzc5+XmOUJT1z8+MYbmt/N/CFFVqr79fNhl59H4x83HuffR9UW+7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]", "Bhaminee");
    	return ok(product.render(prod,finlist));
    }
    
    public static Result loadUserProduct(String p, String u) throws Exception {
    	int p_id = Integer.parseInt(p);
    	Connection connection = DB.getConnection();
    	Product prod=ProductDB.getProd(p_id);
    	Product prod2=ProductDB.getProdType(p_id);
    	List<Product> finlist=RecoDB.getCombinedRecoWithUserName(u,prod2.prod_type,prod2.merchant);
    	return ok(userproduct.render(u, prod,finlist));
    }
    
    public static Result loadProductTypeDetails(int type,int page_num) throws Exception {
    
    	Connection connection = DB.getConnection();
    	List<Product> prods=FilterDBReturnList.getProductByProdTypeAndRatingWithoutColor(type,page_num);
    	List<Product> reco=RecoDB.getProductByProdTypeAndRatingWithUserName(type,"");
    	
    	return ok(productlist.render(prods,reco));
    }
    
    public static Result loadProductTypeDetailsWithUser(int type,String u,int page_num) throws Exception {
    	
    	Connection connection = DB.getConnection();
    	List<Product> prods=FilterDB.getProductByProdTypeAndRatingWithUserName( type,u,page_num);
    	List<Product> reco=RecoDB.getProductByProdTypeAndRatingWithUserName(type,u);
    	
    	return ok(userproductlist.render(u,prods,reco));
    }
    
    
}
