package PinkMessage;

import java.util.*;

public interface PinkMessageService {
	int DELETED = 1;
	PinkMessage findByPinkMessage(int pinkmessage);
	
	List<PinkMessage> getMessageListAll();
	
	List<PinkMessage> getMessageListbyMesname(String Mesname);
	
	void updatePinkMessage(PinkMessage pinkmessage);
	
	void deletePinkMessage(int pinkmessage);
	

}
