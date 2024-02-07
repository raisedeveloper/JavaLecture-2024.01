package mysql.sec06_user;

import java.util.List;

public class UserTest {

	public static void main(String[] args) {
		UserService userSvc = new UserServiceMySQLImpl();
		User user = null;
		// 사용자 만들어주기
//		user = new User("james", "1234", "제임스", "james@gmail.com");
//		userSvc.registerUser(user);
//		user = new User("maria", "1234", "마리아", "maria@naver.com");
//		userSvc.registerUser(user);
//		user = new User("brian", "1234", "브라이언", "brian@gmail.com");
//		userSvc.registerUser(user);
//		user = new User("sarah", "1234", "사라", "sarah@naver.com");		// SELECT * FROM users; 9 - 15 번줄이 Heidi SQL에서 같은내용 확인가능
//		userSvc.registerUser(user);
		
//		user = userSvc.getUserByUid("admin");
//		System.out.println(user);
	
//		user = userSvc.getUserByUid("james");
//		System.out.println(user);
		
//		System.out.println(userSvc.login("admin", "1234"));		// 옳은 아이디
//		System.out.println(userSvc.login("admin", "asdf"));		// 틀린 아이디
//		System.out.println(userSvc.login("james", "1234"));		// 없는 아이디
		
		List<User> list = userSvc.getUserList(3);
		list.forEach(x -> System.out.println(x));
		
		userSvc.close();
	}
}