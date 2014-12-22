package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

@Entity
public class CustomOrders extends Model {
	@Id
	public int id;
	public int cust_id,merchant_id,prod_type_id,color_id;
	public int qty;
	public Date date_created;
	public boolean status;
	public String descr;
}
