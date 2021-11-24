package dto;

public class AdminDTO {
	public String adm_id;
	public String adm_pw;
	public String adm_name;
	public int adm_number;
	public String adm_phonenum;

	public AdminDTO() {
	}

	public AdminDTO(String adm_id, String adm_pw, String adm_name, int adm_number, String adm_phonenum) {
		this.adm_id = adm_id;
		this.adm_pw = adm_pw;
		this.adm_name = adm_name;
		this.adm_number = adm_number;
		this.adm_phonenum = adm_phonenum;
	}

	public AdminDTO(String[] datas) {
		this.adm_id = datas[0];
		this.adm_pw = datas[1];
		this.adm_name = datas[2];
		this.adm_number = Integer.parseInt(datas[3]);
		this.adm_phonenum = datas[4];
	}

	@Override
	public String toString() {
		return adm_id + "\t" + adm_pw + "\t" + adm_name + "\t" + adm_number + "\t" + adm_phonenum + "\t";
	}
}
