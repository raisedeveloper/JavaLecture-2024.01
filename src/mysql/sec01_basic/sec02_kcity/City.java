package mysql.sec01_basic.sec02_kcity;

/*
*  City DTO(Data Transfer Object), VO(Value Object)
*/

public class City {
	// 생성자
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	// 기본 생성자
	public City() { }
	public City(String name, String countryCode, String district, int population) {
		super();
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	// toString
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
	// Getter Setter 불러오기 / 새로 입력하기
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}
