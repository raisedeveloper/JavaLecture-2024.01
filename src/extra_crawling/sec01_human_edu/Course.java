package extra_crawling.sec01_human_edu;

public class Course {
	private String place;
	private String title;
	private String desc;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String place, String title, String desc) {
		super();
		this.place = place;
		this.title = title;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return String.format("[[%s]] - %s\n\t\t%s", place, title, desc); // [[]] 장소를 지정
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	}


