package dto;

public class StoreDTO {
	public int str_num;
	public String str_id;
	public String str_name;
	public String str_addr;
	
	public StoreDTO(int str_num, String str_id, String str_name, String str_addr) {
		this.str_num = str_num;
		this.str_id = str_id;
		this.str_name = str_name;
		this.str_addr = str_addr;
	}
	
	public StoreDTO(String[] datas) {
		this.str_num = Integer.parseInt(datas[0]);
		this.str_id = datas[1];
		this.str_name = datas[2];
		this.str_addr = datas[3];
	}
	
	@Override
	public String toString() {
		return str_num+"\t"+str_id+"\t"+str_name+"\t"+str_addr;
	}
}
