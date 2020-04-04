package lesson02_DI_Maven_Stuff;

import lesson02_DI_Maven_Battery.Battery;

public class Laptop {
	private String serialNo;
	private Battery battery;
	
//	노트북 객체를 만들 때, 건전지가 내장되어 만들어 집니다.
	public Laptop(Battery battery) {
		this.battery = battery;
		
		System.out.println("Laptop 생성자가 호출 되었습니다.");
	}

//	노트북 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
	public void setBattery(Battery battery) {
		this.battery = battery;
	}


	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
		System.out.println("Laptop Setter가 호출 되었습니다.");
	}
	
}
