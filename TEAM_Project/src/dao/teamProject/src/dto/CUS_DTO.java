package dto;

public class CUS_DTO {
	// Alt + Shift + A > Shift + 커서 이동으로 영역 선택 : 여러줄 동시에 수정
	// 끝났으면 다시 Alt + Shift + A로 빠져나오기
	public String cusID;
	public String cusPW;
	public String cusName;
	public String cusPhone;
	public String cusAddr;

	public CUS_DTO() {
	}

	public CUS_DTO(String cusID, String cusPW, String cusName, String cusPhone, String cusAddr) {
		this.cusID = cusID;
		this.cusPW = cusPW;
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusAddr = cusAddr;
	}

	public CUS_DTO(String[] datas) {
		this.cusID = datas[0];
		this.cusPW = datas[1];
		this.cusName = datas[2];
		this.cusPhone = datas[4];
		this.cusAddr = datas[5];
	}

	@Override
	public String toString() {
		return cusID + "\t" + cusPW + "\t" + cusName + "\t" + cusPhone + "\t" + cusAddr;
	}
}
