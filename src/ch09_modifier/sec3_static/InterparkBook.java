package ch09_modifier.sec3_static;

public class InterparkBook {
	private int rank;
	private String title;
	private String author;
	private String translator;
	private String company;
	private int price;
	
	public InterparkBook() { }
	public InterparkBook(int rank, String title, String author, String translator, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	
	// 'translator'가 없으면 출력하지 않고
	// 금액에 천단위 구분기호 추가
	@Override
	public String toString() {
		return "InterparkBook [rank=" + rank + ", title=" + title + ", author=" + author 
				+ ((translator == null) ? "" : ", translator=" + translator)
				+ ", company=" + company 
				+ ", price=" + String.format("%,d", price) + "]";
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