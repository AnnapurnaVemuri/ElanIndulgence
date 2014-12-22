package controllers;

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

public class Application extends Controller {

    public static Result loadMain() {
        return ok(main.render("ElanIndulgence", ""));
    }
    
    public static Result loadProduct() {
        return ok(product.render());
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
					return ok(user.render(username, "TRUE"));
				} else {
					return ok(user.render(username, "FALSE"));
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

}
