package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class CustomizedOrders extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public int id;
	
	public String custusername;
	public String merchantname;
	public String prodtype;
	public List<String> prefcolors = new ArrayList<String>();
	public List<CustomOrderMessages> messages = new ArrayList<CustomOrderMessages>();
	public String budgetrange;
	public String description;
	public String colorsList;
	
	public static Finder<String,CustomizedOrders> find = new Finder<String,CustomizedOrders>(
	        String.class, CustomizedOrders.class
	); 
	
	public static List<CustomizedOrders> findInvolving(String user) {
        return find.where()
            .eq("custusername", user)
            .findList();
    }
	
	public static List<CustomizedOrders> findUsingMerchantName(String merchant) {
        return find.where()
            .eq("merchantname", merchant)
            .findList();
    }
	
	public static List<CustomizedOrders> findUsingId(int id) {
        return find.where()
            .eq("id", id)
            .findList();
    }
}
