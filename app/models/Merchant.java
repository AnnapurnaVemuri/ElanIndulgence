package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Merchant extends Model {
	@Id
	public int merchant_id;
	public String name;
	public String username;
	public String email;
	public String password;
	public boolean is_designer;
	
}
