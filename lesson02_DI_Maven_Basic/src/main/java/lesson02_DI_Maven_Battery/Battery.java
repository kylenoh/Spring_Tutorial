package lesson02_DI_Maven_Battery;

public class Battery {
	private Battery battery;

	public Battery() {

	}
	
	public Battery(Battery battery) {
		this.battery = battery;
		
		System.out.println("Battery 생성자가 호출 되었습니다.");
	}
	
	
}
