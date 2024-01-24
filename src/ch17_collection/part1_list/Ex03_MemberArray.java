package ch17_collection.part1_list;

import java.time.LocalDateTime;

public class Ex03_MemberArray {

	public class Member {
		private int mid;
		private String content;
		private String writer;
		private LocalDateTime modTime;
		private int isDeleted;

		public Member() {
			super();
		}

		public Member(int mid, String content, String writer, LocalDateTime modTime, int isDeleted) {
			super();
			this.mid = mid;
			this.content = content;
			this.writer = writer;
			this.modTime = modTime;
			this.isDeleted = isDeleted;
		}

		@Override
		public String toString() {
			return "Member [mid=" + mid + ", content=" + content + ", writer=" + writer + "]";
		}

	}

}
