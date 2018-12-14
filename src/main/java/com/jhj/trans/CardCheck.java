package com.jhj.trans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CardCheck {
// Advice

	// join points
	@Around("execution(* com.jhj.trans.Transport.*())")
	public Object check(ProceedingJoinPoint joinPoint) {
		System.out.println("카드찍기");
		System.out.println("학생입니다");

		Object obj = null;
		try {
			obj = joinPoint.proceed(); // bus()
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("카드찍기");
		System.out.println("삑--");
		return obj;
	}

	@Before("execution(* com.jhj.trans.Trip.*())")
	public void packing() {
		System.out.println("짐 싸기");
	}

	@AfterReturning("execution(* com.jhj.trans.Trip.*())")
	public void back() {
		System.out.println("짐 풀기");
	}
}
