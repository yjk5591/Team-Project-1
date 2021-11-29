package dto;

public class ProductDTO {
	public String menu_name;
	public int menu_price;
	public int menu_num;
	public String menu_category;
	public String menu_id;
	public String menu_review;
	public int menu_avg_rating;
	public boolean menu_new;
	
	public ProductDTO(String menu_name, int menu_price, int menu_num, String menu_category, String menu_id,
			String menu_review, int menu_avg_rating, boolean menu_new) {
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.menu_num = menu_num;
		this.menu_category = menu_category;
		this.menu_id = menu_id;
		this.menu_review = menu_review;
		this.menu_avg_rating = menu_avg_rating;
		this.menu_new = menu_new;
	}
	
	public ProductDTO(String[] datas) {
		this.menu_num = Integer.parseInt(datas[0]);
		this.menu_id = datas[1];
		this.menu_name = datas[2];
		this.menu_category = datas[3];
		this.menu_price = Integer.parseInt(datas[4]);
		this.menu_avg_rating = Integer.parseInt(datas[5]);
		this.menu_review = datas[6];
		this.menu_new = datas[7] != null;
	}
	@Override
	public String toString() {
		return menu_num+"\t"+menu_id+"\t" + menu_name
				+"\t"+menu_category+"\t"+menu_price
				+"\t"+menu_avg_rating+"\t"+menu_review + menu_new;
	}
}
