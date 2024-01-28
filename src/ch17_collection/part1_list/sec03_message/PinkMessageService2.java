package ch17_collection.part1_list.sec03_message;

import java.util.List;

public interface PinkMessageService2 {
	int DELETED = 1;
	Message findByMid(int mid);
	
	List<Message> getMessageListAll();
	
	List<Message> getMessageListByWriter(String writer);		// 작성자 별 목록
	
	void insertMessage(Message message); 

	void updateMessage(Message message); 

	void deleteMessage(int mid); 
}