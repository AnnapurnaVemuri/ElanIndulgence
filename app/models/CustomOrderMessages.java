package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class CustomOrderMessages extends Model {

	public CustomOrderMessages(int order_id, int msg_id, String message,
			boolean fromCust, Date date_created) {
		super();
		this.order_id = order_id;
		this.msg_id = msg_id;
		this.message = message;
		this.fromCust = fromCust;
		this.date_created = date_created;
	}
	@Override
	public String toString() {
		return "CustomOrderMessages [order_id=" + order_id + ", msg_id="
				+ msg_id + ", message=" + message + ", fromCust=" + fromCust
				+ ", date_created=" + date_created + "]";
	}
	public int order_id;
	@Id
	public int msg_id;
	public String message;
	public boolean fromCust;
	public Date date_created;
}
