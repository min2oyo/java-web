package ten.listener.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener	// HttpSessionBindingListener를 제외한 Listener를 구현한 모든 이벤트 핸들러는 반드시 애너테이션을 이용해서 Listener로 등록
public class LoginImpl implements HttpSessionListener {

	String userId;
	String userPw;
	static int totalUser = 0;

	public LoginImpl() {

	}

	public LoginImpl(String userId, String userPw) {

		this.userId = userId;
		this.userPw = userPw;

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {	// 세션 생성 시 이벤트 처리

		System.out.println("sessionCreated() 실행");
		++totalUser;

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		System.out.println("sessionDestroyed() 실행");
		--totalUser;

	}

}
