package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class Product extends Model{
	public Product(int prod_id, float price, float rating, String photo,
			String merchant) {
		super();
		this.prod_id = prod_id;
		this.price = price;
		this.rating = rating;
		this.photo = photo;
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", price=" + price + ", rating="
				+ rating + ", merchant=" + merchant + "]";//, photo=" + photo + "]";
	}

	public int qty;
	@Id
	public int prod_id;
	public float price;
	public Product() {
		super();
	}

	public float rating;
	public String photo;
	public String merchant;
	
	public int prod_type,merch_id;

}
