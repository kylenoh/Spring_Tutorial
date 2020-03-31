package lesson02_DI_Basic_Stuff;

import lesson02_DI_Basic_Battery.Battery;

public class Laptop {
	private Battery battery;
	
//	노트북 객체를 만들 때, 건전지가 내장되어 만들어 집니다.
	public Laptop(Battery battery) {
		this.battery = battery;
	}

//	노트북 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
	
	
}
