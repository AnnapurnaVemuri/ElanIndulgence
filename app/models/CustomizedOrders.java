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
	public String budgetrange;
	public String description;
	public String colorsList;
}
