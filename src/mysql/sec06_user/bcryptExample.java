package mysql.sec06_user;

import org.mindrot.jbcrypt.BCrypt;		// 우리가 설치한 라이브러리 안에 있음 jar file

public class bcryptExample {

	public static void main(String[] args) {
		String pwd = "1234qwerty";
		String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());    // salt 키를 제너레이션 함
		System.out.println(hashedPwd.length());
		System.out.println(hashedPwd);		
		// syso out 결과 : 60 $2a$10$LXCR2359Xc/eUGyK59mG.eFeJG8MgnKQ4EGejsprVShoWj4KTm/8O
		// hashedPwd : 사용자 등록을 할 때 제너럴해서 DB에 들어가 있음 
		// DB는 hashedPwd 가 들어가고 나는 사용자로부터 정보를 받아서 바로 밑 코드와 같이 비교를 함
		
		// 패스워드가 동일한지 확인
		boolean result = BCrypt.checkpw(pwd, hashedPwd);
		System.out.println(result);			// true
	}

}
