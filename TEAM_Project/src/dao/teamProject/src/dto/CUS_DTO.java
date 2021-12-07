package dto;

public class CUS_DTO {
	// Alt + Shift + A > Shift + Ŀ�� �̵����� ���� ���� : ������ ���ÿ� ����
	// �������� �ٽ� Alt + Shift + A�� ����������
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
