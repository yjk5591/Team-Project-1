package dto;

public class MenuDTO {
	public String menu_name;
	public int menu_price;
	public int menu_num;
	public String menu_category;
	public String menu_id;	
	public int menu_new;
	
	public MenuDTO() {}

	public MenuDTO(String menu_name, int menu_price, int menu_num, String menu_category, String menu_id,
			int menu_new) {
		
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.menu_num = menu_num;
		this.menu_category = menu_category;
		this.menu_id = menu_id;
		this.menu_new = menu_new;
	}

	
	
	
	
}
