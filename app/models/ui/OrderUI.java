package models.ui;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class OrderUI extends Model {
	@Override
	public String toString() {
		return "OrderUI [id=" + id + ", merchant_name=" + merchant_name
				+ ", prod_id=" + prod_id + ", qty=" + qty + ", date_created="
				+ date_created + ", prod_type=" + prod_type + "]";
	}
	@Id
	public int id;
	public OrderUI(int id, String merchant_name, int prod_id, int qty,
			Date date_created, String prod_type) {
		super();
		this.id = id;
		this.merchant_name = merchant_name;
		this.prod_id = prod_id;
		this.qty = qty;
		this.date_created = date_created;
		this.prod_type = prod_type;
	}
	public int prod_id;
	public String merchant_name;
	public int qty;
	public Date date_created;
	public String prod_type;
}
