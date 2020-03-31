package lesson02_DI_Basic_Stuff;

import lesson02_DI_Basic_Battery.Battery;
import lesson02_DI_Basic_Battery.ChargedBattery;

public class Robot {
	private Battery battery;
	
//	로봇이 객체를 만들 때, 건전지가 내장되어 만들어 집니다.
	public Robot() {
		battery = new ChargedBattery();
	}
}
