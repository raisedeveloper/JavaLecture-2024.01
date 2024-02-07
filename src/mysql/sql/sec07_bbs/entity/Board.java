package mysql.SQL.sec07_bbs.entity;

import java.time.LocalDateTime;

public class Board {
	private int bid;
	private String title;
	private String content;
	private String uid;
	private LocalDateTime modTime;
	private int isDeleted;
	private int viewCount;
	private int replyCount;
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
}
