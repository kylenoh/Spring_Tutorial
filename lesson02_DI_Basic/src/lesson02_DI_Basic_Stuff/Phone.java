package lesson02_DI_Basic_Stuff;

import lesson02_DI_Basic_Battery.Battery;

public class Phone {
	
	private Battery battery;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

//	Phone 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
}
