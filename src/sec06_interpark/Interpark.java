package sec06_interpark;

public class Interpark {
	
	//필드, 멤버, 속성
	public int rank;
	public String title;
	public String author;
	public String translator;
	public String company;
	public int price;
	
	// 생성자
	public Interpark() { }
	public Interpark(int rank, String title, String author, String translator, String company, int price) {
		super();
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	
	//메소드
	@Override
	public String toString() {
		return "Interpark [rank=" + rank + ", title=" + title + ", author=" + author 
				+ ((translator == null) ? "" : " , translator=" + translator)
				+ ", company=" + company 
				+ ", price=" + String.format("%,d",price) + "]";
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
