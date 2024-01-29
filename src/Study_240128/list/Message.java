package Study_240128.list;

import java.time.LocalDateTime;
public class Message {

//	public static void main(String[] args) {	 생성자 toString 쓰는 칸엔 Main 필요없음
	
		// 속성 정의
		private int mO;				// 메세지 순서
		private String writer;		// 메세지 작성자
		private String content;		// 메세지 내용
		private LocalDateTime time;	// 메세지 작성 시간
		private int isDeleted;		// 메세지 삭제 여부 ( 0: 삭제되지 않음, 1: 삭제됨)
		
		// 생성자 - 모든 것을 포함해서 생성한 것과 필요한 것만 생성했을 때를 구별해 둠
		public Message(int mO, String writer, String content, LocalDateTime time, int isDeleted) {
			this.mO = mO;
			this.writer = writer;
			this.content = content;
			this.time = time;
			this.isDeleted = isDeleted;
		}
		public Message(int mO, String writer, String content, LocalDateTime time) {
			this.mO = mO;
			this.writer = writer;
			this.content = content;
			this.time = time;
		}
		public Message(int mO, String writer, String content) {
			this.mO = mO;
			this.writer = writer;
			this.content = content;
		}
		public Message(int mO, String writer) {
			this.mO = mO;
			this.writer = writer;
		}
		public Message(int mO) {
			this.mO = mO;
		}
		public Message() {
		}
		// 객체를 문자열로 표현하는 메서드
		@Override
		public String toString() {	// 이것은 필요한 오버라이드인가요? 필요없다면 이거 없어도 잘 돌아가서인가요?
			return "Message [mO=" + mO + ", writer=" + writer + ", content=" + content + ", time=" + time
					+ ", isDeleted=" + isDeleted + "]";
		}
		// 게터 및 세터 메서드
		public int getmO() {
			return mO;
		}
		public void setmO(int mO) {
			this.mO = mO;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public LocalDateTime getTime() {
			return time;
		}
		public void setTime(LocalDateTime time) {
			this.time = time;
		}
		public int getIsDeleted() {
			return isDeleted;
		}
		public void setIsDeleted(int isDeleted) {
			this.isDeleted = isDeleted;
		}

	}
