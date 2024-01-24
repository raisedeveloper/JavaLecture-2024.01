package EX99_Message;

public class MessageMain {
	private static MessageServiceArrayImpl msImpl = new MessageServiceArrayImpl();
	
	public static void main(String[] args) {
		msImpl.messageList();
	}

}
