package lesson03_Maven_Resource;

import org.springframework.context.support.GenericXmlApplicationContext;

import lesson03_Maven_Resource_DTO.Student;
import lesson03_Maven_Resource_Service.StudentAllSelectService;
import lesson03_Maven_Resource_Service.StudentRegisterService;

public class Main {
	public static void main(String[] args) {
		
//		학생을 등록할 배열을 생성합니다.
		String[] Codes = { "1", "2", "3", "4"};
		String[] Ids = { "banana", "apple", "melon", "lemon"};
		String[] Pws = { "123", "456", "789", "963"};
		String[] Names = { "바나나", "사과", "메론", "레몬"};
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		for (int i = 0; i < Codes.length; i++) {
			Student student = new Student(Codes[i], Ids[i], Pws[i], Names[i]);
			registerService.register(student);
		}
		
		StudentAllSelectService selectService = ctx.getBean("selectService", StudentAllSelectService.class);
		
		System.out.println("\n\n------------------------------------");
		for (int i = 0; i < Codes.length; i++) {
			Student student = selectService.select(Codes[i]);
			System.out.print(student.getCode() + "\t: ");
			System.out.print(student.getId() + "\t: ");
			System.out.print(student.getPw() + "\t: ");
			System.out.println(student.getName());
			System.out.println("------------------------------------");
		}
		System.out.println("\n\n");
		
		ctx.close();
	}
}
