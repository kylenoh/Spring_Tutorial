package lesson04_Spring_JavaConfig_Division;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lesson04_Maven_JavaConfig_Division.config.applicationConfig;
import lesson04_Maven_JavaConfig_Division.config.dataBaseConfig;
import lesson04_Maven_JavaConfig_Division.config.propertyConfig;
import lesson04_Maven_JavaConfig_Division.dto.Student;
import lesson04_Maven_JavaConfig_Division.service.StudentAllSelectService;
import lesson04_Maven_JavaConfig_Division.service.StudentRegisterService;
import lesson04_Maven_JavaConfig_Division.service.StudentSelectByIdService;

public class Main {
	public static void main(String[] args) {
		
//		학생을 등록할 배열을 생성합니다.
		String[] Codes = { "1", "2", "3", "4"};
		String[] Ids = { "banana", "apple", "melon", "lemon"};
		String[] Pws = { "123", "456", "789", "963"};
		String[] Names = { "바나나", "사과", "메론", "레몬"};

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(applicationConfig.class, dataBaseConfig.class, propertyConfig.class);
		
		
		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		for (int j = 0; j < Codes.length; j++) {
			Student student = new Student(Codes[j], Ids[j], Pws[j], Names[j]);
			registerService.register(student);
		}
		
		StudentAllSelectService allSelectService = ctx.getBean("allSelectService", StudentAllSelectService.class);
		Map<String, Student> allStudent = allSelectService.Select();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("Code:" + student.getCode() + "\t");
			System.out.print("|Id:" + student.getId() + "\t");
			System.out.print("|Pw:" + student.getPw() + "\t");
			System.out.print("|Name:" + student.getName() + "\t\r");

		}

		Scanner scanner = null;
		
		StudentSelectByIdService selectService = ctx.getBean("selectService", StudentSelectByIdService.class);
		
		while (true) {
			scanner = new Scanner(System.in);
			String str = "";

			System.out.println("\n==================================================================="
					+ "==============================================================================");
			System.out.println("Select number.");
			System.out.println("1. Check student information");
			System.out.println("2. Exit");

			str = scanner.next();
			if (str.equals("2")) {
				System.out.println("Bye~~");
				break;
			} else {
				System.out.println("Please input your class number.");

				str = scanner.next();
				Student student = selectService.select(str);
				System.out.print("Code:" + student.getCode() + "\t");
				System.out.print("|Id:" + student.getId() + "\t");
				System.out.print("|Pw:" + student.getPw() + "\t");
				System.out.print("|Name:" + student.getName() + "\t");
			}
		}
		scanner.close();
		ctx.close();
	}
}
