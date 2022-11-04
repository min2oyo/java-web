package com.spring.member;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));	// 실행 시 member.xml에 설정한 대로 빈을 생성한 후 주입함

		MemberService service = (MemberService) factory.getBean("memberService");	// id가 memberService인 빈을 가져옴
		service.listMembers();

	}

}
