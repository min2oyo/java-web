package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");	// AOPTest.xml을 읽어 들여 빈을 생성
		Calculator cal = (Calculator) context.getBean("proxyCal");	// id가 proxyCal인 빈에 접근

		cal.add(100, 20);	// 메서드 호출 전후에 어드바이스 빈이 적용
		System.out.println();

		cal.subtract(100, 20);
		System.out.println();

		cal.multiply(100, 20);
		System.out.println();

		cal.divide(100, 20);
		System.out.println();

	}

}
