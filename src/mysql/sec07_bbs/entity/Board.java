package mysql.sec07_bbs.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Board {
	private int bid;
	private String title;
	private String content;
	private String uid;
	private LocalDateTime modTime;
	private int isDeleted;
	private int viewCount;
	private int replyCount;
	private String uname;		// Board table 에는 없지만 join 을 통해서 얻어오는 정보
	private List<Reply> replyList;
	
	public Board() { }
	
	public Board(int bid, String title, String content, String uid, LocalDateTime modTime, int isDeleted, int viewCount,
			int replyCount, String uname) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.uid = uid;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.uname = uname;
	}

	public Board(String title, String content, String uid) {
		super();
		this.title = title;
		this.content = content;
		this.uid = uid;
	}
	
	public Board(String title, String content, String uid, LocalDateTime modTime, int isDeleted, int viewCount,
			int replyCount) {
		super();
		this.title = title;
		this.content = content;
		this.uid = uid;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.uname = uname;		// 
	}

	public Board(int bid, String title, String content, String uid, LocalDateTime modTime, int isDeleted, int viewCount,
			int replyCount) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.uid = uid;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
	}
	
	@Override
	public String toString() {
		return "Board [bid=" + bid + ", title=" + title + ", content=" + content + ", uid=" + uid + ", modTime="
				+ modTime + ", isDeleted=" + isDeleted + ", viewCount=" + viewCount + ", replyCount=" + replyCount
				+ "]";
	}
	
	// Method : What about? "%3d" == 간격 표현 replyCount viewCount isDelete=X content(본문)X title LocalDateTime
	public String listForm() {
		return String.format("%3d %2d %2d %s %s | %s",
				bid, viewCount, replyCount, 
				modTime.toString().replace("T", " ").substring(2, 16), uname, title); 
		
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public LocalDateTime getModTime() {
		return modTime;
	}
	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
}
