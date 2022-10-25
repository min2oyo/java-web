package ten.listener.bindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {	// HttpSessionBindingListener를 구현해 세션에 바인딩 시 이벤트 처리

	String userId;
	String userPw;
	static int totalUser = 0;	// 세션에 바인딩 시 1씩 증가

	public LoginImpl() {

	}

	public LoginImpl(String userId, String userPw) {

		this.userId = userId;
		this.userPw = userPw;

	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {		// 세션에 저장 시 접속자 수 증가

		System.out.println("사용자 접속");
		++totalUser;

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {	// 세션에 소멸 시 접속자 수 감소

		System.out.println("사용자 접속 해제");
		totalUser--;

	}

}
