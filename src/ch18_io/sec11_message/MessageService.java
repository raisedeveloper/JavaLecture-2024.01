package ch18_io.sec11_message;

import java.util.List;

import ch18_io.sec11_message.Message;

public interface MessageService {
	int DELETED = 1;
	Message findByMid(int mid);
	
	List<Message> getMessageListAll();
	
	List<Message> getMessageListByWriter(String writer);		// 작성자 별 목록
	
	void insertMessage(Message message); 

	void updateMessage(Message message); 

	void deleteMessage(int mid); 
}
