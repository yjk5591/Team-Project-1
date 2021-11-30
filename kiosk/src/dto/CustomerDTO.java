package dto;

public class CustomerDTO {
	public String cus_id;
	public int cus_num;
	public String cus_name;
	public String cus_pw;
	public String cus_addr;
	public String cus_addr2;
	public int cus_point;
	public String cus_phone;
	public int cus_coupons;
	
	public CustomerDTO(String cus_id, int cus_num, String cus_name, String cus_pw, String cus_addr, String cus_addr2,
			int cus_point, String cus_phone, int cus_coupons) {
		this.cus_id = cus_id;
		this.cus_num = cus_num;
		this.cus_name = cus_name;
		this.cus_pw = cus_pw;
		this.cus_addr = cus_addr;
		this.cus_addr2 = cus_addr2;
		this.cus_point = cus_point;
		this.cus_phone = cus_phone;
		this.cus_coupons = cus_coupons;
	}
	
	public CustomerDTO(String[] datas) {
		this.cus_id = datas[0];
		this.cus_num = Integer.parseInt(datas[1]);
		this.cus_name = datas[2];
		this.cus_pw = datas[3];
		this.cus_addr = datas[4];
		this.cus_addr2 = datas[5];
		this.cus_point = Integer.parseInt(datas[6]);
		this.cus_phone = datas[7];
		this.cus_coupons = Integer.parseInt(datas[8]);		
	}
	@Override
	public String toString() {
		return cus_id+"\t"+cus_num+"\t" + cus_name
				+"\t"+cus_pw+"\t"+cus_addr+"\t"+cus_addr2
				+"\t"+cus_point+"\t"+cus_phone+"\t"+cus_coupons;
	}
}