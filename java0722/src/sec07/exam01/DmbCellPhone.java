package sec07.exam01;

public class DmbCellPhone extends CellPhone {
	int channel;
	
	DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		
		this.channel = channel;
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 방송 수신 시작");
	}
	
	void changeChannelDmb(int channel) {
		System.out.println("채널 " + channel + "번으로 변경");
	}
	
	void turnOffDmb() {
		System.out.println("방송 수신 종료");
	}
}
