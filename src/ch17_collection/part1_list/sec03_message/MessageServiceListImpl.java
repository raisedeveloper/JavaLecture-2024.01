package ch17_collection.part1_list.sec03_message;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceListImpl implements MessageService {
	private List<Message> messageList = new ArrayList<>(); 			// ♥ Memorizing 외우기 공식!!!!
	private int index = 0;

	@Override
	public Message findByMid(int mid) {
		for (Message msg: messageList) {
//			if (msg == null)		// 이건 Array 타입일 때 쓰는 공식임
//				break;
			if (mid == msg.getMid())
				return msg;
		}
		return null;
	}

	@Override
	public List<Message> getMessageListAll() {
		List <Message> mList = getMessageListAll();
		mList.forEach(x -> System.out.println(x));
		System.out.println("==================================");
	
		return null;
	}
	

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		List<Message> mList = getMessageListByWriter("writer");
		mList.forEach(x -> System.out.println(x));
		System.out.println("===================================");

		return null;
	}

	@Override
	public void insertMessage(Message message) {
		Member message = new Massage("1" , "동호", "안녕", t);
		insertMessage(message);
		list.forEach(x -> )
		
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMessage(int mid) {
		// TODO Auto-generated method stub
		
	}

}