package lesson02_DI_Spring_Stuff;

import lesson02_DI_Spring_Battery.Battery;

public class Robot {
	private Battery battery;
	
//	로봇이 객체를 만들 때, 건전지가 내장되어 만들어 집니다.
	public Robot() {
		battery = new Battery(battery);
		System.out.println("Robot 생성자가 호출 되었습니다.");
	}
}
