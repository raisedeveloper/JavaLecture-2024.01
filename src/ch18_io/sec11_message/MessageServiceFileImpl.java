package ch18_io.sec11_message;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceFileImpl implements MessageService {
	private List<Message> list = new ArrayList<>();
	private int index = 101;
	private String saveFilename = "c:/Temp/message.ser";

	public MessageServiceFileImpl() {
		File saveFile = new File(saveFilename);
		if (saveFile.exists()) {
			try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
			list = (List<Message>) ois.readObject();
			index += list.size();
			Message msg = list.get(list.size() -1);
			index = msg.getMid() + 1;
			} catch (Exception e) {
			e.printStackTrace();
			}
		} else {
			list.add(new Message(index++, "자바 세계에 오신걸 환영합니다.", "제임스", LocalDateTime.now(), index));
			list.add(new Message(index++, "안녕하세요? 반갑습니다.", "마리아", LocalDateTime.now(), index));
			list.add(new Message(index++, "좋은 하루 되세요.", "브라이언", LocalDateTime.now(), index));
			list.add(new Message(index++, "휴먼교육센터에서 강의를 들어보세요.", "엠마", LocalDateTime.now(), index));
			list.add(new Message(index++, "스프링부트도 함께 배워요.", "제임스", LocalDateTime.now(), index));
		}
	}	

	@Override
	public Message findByMid(int mid) {
		return null;
	}

	@Override
	public List<Message> getMessageListAll() {
		return null;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		return null;
	}

	@Override
	public void insertMessage(Message message) {
	}

	@Override
	public void updateMessage(Message message) {
	}

	@Override
	public void deleteMessage(int mid) {
	}
	

}
