package lesson02_DI_Spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import lesson02_DI_Spring_Battery.Battery;
import lesson02_DI_Spring_Stuff.Laptop;
import lesson02_DI_Spring_Stuff.Phone;
import lesson02_DI_Spring_Stuff.Robot;


public class Main {
	public static void main(String[] args) {
		
//		applicationContext 호출하여 사용하겠다고 선언합니다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		Robot robot = ctx.getBean("robot",Robot.class);

		Phone phone = ctx.getBean("phone",Phone.class);
		
		Laptop laptop = ctx.getBean("laptop",Laptop.class);
		
		ctx.close();
	}
}
