package mysql.sec01_basic.sec02_kcity;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		CityDao cityDao = new CityDao();

		City city = cityDao.getCityById(2340);
		System.out.println(city);

		city = cityDao.getCityByName("수원");
		System.out.println(city);
		System.out.println("=================================================================================");
		
		List<City> list = cityDao.getCityListAll();
		
		list = cityDao.getCityListByDistrict("kyonggi");
		list.forEach(x -> System.out.println(x));
		
		// 여기까지는  Select 만 한것임
		// 이하 부터는 insert update delete 할 것임
		
//		city = new City("화성", "KOR", "Kyonggi", 900000);		//생성자를 별도로 만들어 주어야 빨간줄 없어짐
//		cityDao.insertCity(city);
		
		// insert 수정 시 추가된 항목 이하 4줄
//		city = cityDao.getCityById(2396);
//		city.setName("의왕");
//		city.setPopulation(500000);
//		cityDao.updateCity(city);
		
		cityDao.deleteCity(2402);
		
		list = cityDao.getCityListByDistrict("Kyonggi");
		list.forEach(x -> System.out.println(x));
		
	}
}

//	파라메터가 있을 때 ????? 뭘 넣는다고????? prfepared statement
//	파라메터가 없을 때 이뗴는 뭘 넣는다고?? 그냥 statement
//	갖고올것이 잇으면 엑슼뭐트 ㅁ퀄 엑시큐트 업데이트 업데이트 지우고 수정하고 할때 ㅇㅅㅇ
	
//	crud 관련 함수 dao 기본적인 5개 데이터 가져오기 리스트 가져오기 업데이트 딜리트 인설트

//한개는 DTO
//여러개는 리스트의 DTO 타입 
//잊지말기!
//잊어도 코드를 보고 금방 따라갈 수 있는형태로 만들기 
