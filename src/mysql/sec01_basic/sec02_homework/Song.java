package mysql.sec01_basic.sec02_homework;

/*
*  Song DTO(Data Transfer Object), VO(Value Object)
*/

public class Song {

	// 생성자
	private int sid;
	private String title;
	private String lyrics;

	// 기본 생성자
	public Song() {
	}

	public Song(String title, String lyrics) {
		super();
		this.title = title;
		this.lyrics = lyrics;
	}

	public Song(int sid, String title, String lyrics) {
		super();
		this.sid = sid;
		this.title = title;
		this.lyrics = lyrics;
	}

	// toString
	@Override
	public String toString() {
		return "Song [sid=" + sid + ", title=" + title + ", lyrics=" + lyrics + "]";
	}

	// Getter Setter 불러오기 / 새로 입력하기
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
}
