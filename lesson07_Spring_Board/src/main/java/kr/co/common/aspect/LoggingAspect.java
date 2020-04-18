package kr.co.common.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	public void beforeLogging(JoinPoint thisJoinPoint) {
		System.out.println("Before AOP 호출");
	}

	public void aroundLogging(JoinPoint thisJoinPoint) {
		System.out.println("Around AOP 호출");
	}


	public void afterLogging(JoinPoint thisJoinPoint) {
		System.out.println("After AOP 호출");
	}

}
