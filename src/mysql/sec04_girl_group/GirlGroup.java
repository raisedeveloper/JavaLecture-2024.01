package mysql.sec04_girl_group;

import java.time.LocalDate;

public class GirlGroup {
	private int gid;	
	private String name;
	private LocalDate debut;
	private int hitSongId;				// 우리는 hitSongId 가 아니라 title이 중요함, hitSongId = title을 만들어서 insert/ update 할 때 사용하는 필드
	private String hitSongTitle;		// Select 할 때 사용하는 필드
	
	public GirlGroup() { }
	
	public GirlGroup(int gid, String name, LocalDate debut, int hitSongId, String hitSongTitle) {
		super();
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
		this.hitSongTitle = hitSongTitle;
	}
	public GirlGroup(int gid, String name, LocalDate debut, int hitSongId) {  // update 할 때 필요, update 시 사용
		super();
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	public GirlGroup(String name, LocalDate debut, int hitSongId) {  // insert 할 때 사용되는 생성자 name / debut / hitSongId
		super();					
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	@Override
	public String toString() {
		return "GirlGroup2 [gid=" + gid + ", name=" + name + ", debut=" + debut + ", + hitSongTitle=" + hitSongTitle + "]";
		// hitSongId 부분을 삭제함 _ 필요없음
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public int getHitSongId() {
		return hitSongId;
	}
	public void setHitSongId(int hitSongId) {
		this.hitSongId = hitSongId;
	}
	public String getHitSongTitle() {
		return hitSongTitle;
	}
	public void setHitSongTitle(String hitSongTitle) {
		this.hitSongTitle = hitSongTitle;
	}
}