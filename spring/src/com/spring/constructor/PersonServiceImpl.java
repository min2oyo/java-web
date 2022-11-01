package com.spring.constructor;

public class PersonServiceImpl implements PersonService {

	private String name;
	private int age;

	public void setName(String name) {	// person.xml의 <value> 태그의 값을 setter를 이용해 설정

		this.name = name;

	}

	@Override
	public void sayHello() {

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);

	}

}
