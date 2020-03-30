package lesson01_Create_Maven_Project;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
//		기존 Java 호출 방식
		PrintWord print = new PrintWord();
		print.printConsole();
		
//		Spring을 사용한 호출 방식
		
//		applicationContext 호출하여 사용하겠다고 선언합니다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
//		호출한 것중 해당 Bean파일을 가져옵니다.
		PrintWord printText = ctx.getBean("print",PrintWord.class);
		printText.printConsole();
		
		ctx.close();
	}
}
