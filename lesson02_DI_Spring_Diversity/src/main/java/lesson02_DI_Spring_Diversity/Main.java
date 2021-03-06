package lesson02_DI_Spring_Diversity;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import lesson02_DI_Spring_Diversity_DTO.Student;
import lesson02_DI_Spring_Diversity_Service.StudentAllSelectService;
import lesson02_DI_Spring_Diversity_Service.StudentRegisterService;
import lesson02_DI_Spring_Diversity_Service.StudentSelectByIdService;
import lesson02_DI_Spring_Diversity_assembler.StudentAssembler;

public class Main {
	public static void main(String[] args) {
		
//		학생을 등록할 배열을 생성합니다.
		String[] Codes = { "1", "2", "3", "4"};
		String[] Ids = { "banana", "apple", "melon", "lemon"};
		String[] Pws = { "123", "456", "789", "963"};
		String[] Names = { "바나나", "사과", "메론", "레몬"};

//		Dao,Service 를 모두 호출 합니다.
		StudentAssembler assembler = new StudentAssembler();

//		등록 서비스를 호출 합니다. 
		StudentRegisterService registerService = assembler.getRegisterService();
		
//		반복문을 돌면서 HashMap에 <Code,학생> 을 등록합니다.
		for (int j = 0; j < Codes.length; j++) {
			Student student = new Student(Codes[j], Ids[j], Pws[j], Names[j]);
			registerService.register(student);
		}
		
/*
 * 		수정 서비스를 호출 할 수 있습니다.
		StudentModifyService modifyService = assembler.getModifyService();
		modifyService.modify(new Student("1", "Jamon", "123", "자몽"));
		StudentSelectByIdService selectService = assembler.getSelectbyIdService();
		Student modifiedStudent = selectService.select("1");
		System.out.print("Code:" + modifiedStudent.getCode() + "\t");
		System.out.print("|Id:" + modifiedStudent.getId() + "\t");
		System.out.print("|Pw:" + modifiedStudent.getPw() + "\t");
		System.out.print("|Name:" + modifiedStudent.getName() + "\t\r");
*/
		

		StudentAllSelectService allSelectService = assembler.getSelectAllService();
		Map<String, Student> allStudent = allSelectService.Select();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();

//		반복문을 돌면서 Map에 담긴 모든 학생 정보를 출력합니다.
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("Code:" + student.getCode() + "\t");
			System.out.print("|Id:" + student.getId() + "\t");
			System.out.print("|Pw:" + student.getPw() + "\t");
			System.out.print("|Name:" + student.getName() + "\t\r");

		}

		Scanner scanner = null;
		StudentSelectByIdService selectService = assembler.getSelectbyIdService();
		
//		반복문을 돌면서 입력 값에 따라 결과를 출력합니다.
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
	}
}
