package dto;

public class AdminDTO {
	public String admin_id;
	public String admin_pw;
	public String admin_name;
	public int admin_num;
	public String admin_phone;
	public String admin_store_id;
	
	public AdminDTO() {}

	
	
	public AdminDTO(String admin_id, String admin_pw, String admin_name, int admin_num, String admin_phone,
			String admin_store_id) {
	
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
		this.admin_name = admin_name;
		this.admin_num = admin_num;
		this.admin_phone = admin_phone;
		this.admin_store_id = admin_store_id;
	}
	public AdminDTO(String[] datas) {
		this.admin_id = datas[0];
		this.admin_pw = datas[1];
		this.admin_name = datas[2];
		this.admin_num = Integer.parseInt(datas[3]);
		this.admin_phone = datas[4];
		this.admin_store_id= datas[5];
		
	}


	@Override
	public String toString() {
		return admin_id+"\t"+admin_pw+"\t"+admin_name+"\t"+admin_num+"\t"+admin_phone+"\t"+admin_store_id;
	}
	
	
}