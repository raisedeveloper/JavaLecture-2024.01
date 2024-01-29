package PinkMessage;

import java.time.LocalDateTime;
public class PinkMessage {
	
	// 생성자 파트
	private int mO;					// 'mO': message order
	private String mWriter;			// message writer
	private String mContent;		// message content
	private LocalDateTime mTime;	// message Time
	private int isDeleted;			// 삭제
	
	public PinkMessage(int mO, String mWriter, String mContent, LocalDateTime mTime, int isDeleted) {
		this.mO = mO;
		this.mWriter = mWriter;
		this.mContent = mContent;
		this.mTime = mTime;
		this.isDeleted = isDeleted;
	}
	
	public int getmO() {
		return mO;
	}
	public void setmO(int mO) {
		this.mO = mO;
	}
	public String getmWriter() {
		return mWriter;
	}
	public void setmWriter(String mWriter) {
		this.mWriter = mWriter;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public LocalDateTime getmTime() {
		return mTime;
	}
	public void setmTime(LocalDateTime mTime) {
		this.mTime = mTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
	
	
	
	
}