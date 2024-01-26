package PinkMessage;

import java.time.LocalDateTime;
import java.util.*;
public class PinkMessage {
	
	// 생성자 파트
	private int MesListNum;
	private String MesName;
	private String MesContent;
	private LocalDateTime MesTime;
	private int isDeleted;
	
	public PinkMessage() {		// 이거 만드는 이유?
		
	}

	//public PinkMessage(int i, String string, LocalDateTime now) { } // 이게 생성되니 impl의 에러가 사라짐 13~18번째 줄
	public PinkMessage(int i, String string, LocalDateTime now) {
	}
	
	@Override
	public String toString() {
		return "PinkMessage [MesListNum=" + MesListNum + ", MesName=" + MesName + ", MesContent=" + MesContent
				+ ", MesTime=" + MesTime + ", isDeleted=" + isDeleted + "]";
	}
	public int getMesListNum() {
		return MesListNum;
	}
	public void setMesListNum(int mesListNum) {
		MesListNum = mesListNum;
	}
	public String getMesName() {
		return MesName;
	}
	public void setMesName(String mesName) {
		MesName = mesName;
	}
	public String getMesContent() {
		return MesContent;
	}
	public void setMesContent(String mesContent) {
		MesContent = mesContent;
	}
	public LocalDateTime getMesTime() {
		return MesTime;
	}
	public void setMesTime(LocalDateTime mesTime) {
		MesTime = mesTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
