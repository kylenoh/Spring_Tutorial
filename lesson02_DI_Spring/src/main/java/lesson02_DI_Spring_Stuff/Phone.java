package lesson02_DI_Spring_Stuff;

import lesson02_DI_Spring_Battery.Battery;

public class Phone {
	private String number;
	private Battery battery;

	public Phone() {
		System.out.println("Phone 생성자가 호출 되었습니다.");
	}

	public Phone(Battery battery) {
		this.battery = battery;
	}
	
//	Phone 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
	public void setBattery(Battery battery) {
		this.battery = battery;
		
	}

	public void setNumber(String number) {
		this.number = number;
		System.out.println("Phone Setter가 호출 되었습니다.");
	}
	
}
