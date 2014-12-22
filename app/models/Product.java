package models;

public class Product {
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
				+ rating + ", merchant=" + merchant + ", photo=" + photo + "]";
	}

	public int prod_id;
	public float price;
	public float rating;
	public String photo;
	public String merchant;

}
