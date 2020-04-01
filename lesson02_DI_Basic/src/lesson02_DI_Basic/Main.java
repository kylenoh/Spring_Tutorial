package lesson02_DI_Basic;

import lesson02_DI_Basic_Battery.Battery;
import lesson02_DI_Basic_Battery.ChargedBattery;
import lesson02_DI_Basic_Battery.UnChargedBattery;
import lesson02_DI_Basic_Stuff.Laptop;
import lesson02_DI_Basic_Stuff.Phone;
import lesson02_DI_Basic_Stuff.Robot;

public class Main {
	public static void main(String[] args) {
		Battery chargedBattery = new ChargedBattery();
		Battery battery = new UnChargedBattery();
		
//		로봇이 객체를 만들 때, 건전지가 내장되어 만들어 집니다.
		Robot robot = new Robot();

//		Phone 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
		Phone phone = new Phone();
		phone.setBattery(chargedBattery);
		
//		노트북 객체를 만들때, setBattery를 통하여 외부에서 값을 넣어 줄 수 있습니다.
		Laptop laptop = new Laptop(battery);
	}
}
