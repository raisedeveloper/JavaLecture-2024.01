package mysql.sec05_message;

import java.util.List;

public class MessageTest {

	public static void main(String[] args) {
		MessageDao msgDao = new MessageDao();
		
		Message msg = msgDao.getMessageByMid(101);
		System.out.println(msg);
		
//		msg = new Message("집에 빨리 가고 싶어요.", "브라이언");
//		msgDao.insertMessage(msg);
		
		msg = msgDao.getMessageByMid(107);
		msg.setContent("MessageDao 프로그램을 완성시키고 싶어요.");
		msgDao.updateMessage(msg);
	
		List<Message> list = msgDao.getMessageListByWriter("브라이언");
		list.forEach(x -> System.out.println(x));
	}

}
