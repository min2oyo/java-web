package com.spring.constructor;

public class PersonServiceImpl implements PersonService {

	private String name;
	private int age;

	public PersonServiceImpl(String name) {								// person.xml에서 인자가 1개인 생성자 설정시 사용

		this.name = name;

	}

	public PersonServiceImpl(String name, int age) {	// person.xml에서 인자가 2개인 생성자 설정시 사용

		this.name = name;
		this.age = age;

	}

	@Override
	public void sayHello() {

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);

	}

}
