package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Merchant extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	public int merchant_id;
	public String name;
	public String username;
	public String email;
	public String password;
	public boolean is_designer;
	
	public static Finder<String,Merchant> find = new Finder<String,Merchant>(
	        String.class, Merchant.class
	); 
	
	public static List<Merchant> findInvolving(String user) {
        return find.where()
            .eq("username", user)
            .findList();
    }
	
	public static List<Merchant> findUsingName(String user) {
        return find.where()
            .eq("name", user)
            .findList();
    }
}
