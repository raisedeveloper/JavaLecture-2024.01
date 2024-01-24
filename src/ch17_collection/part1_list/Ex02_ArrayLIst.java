package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02_ArrayLIst {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();			// 대부분 이와 같이 사용 <>general 이라 객체밖에못옴
		ArrayList<String> aList = new ArrayList<>();	// 이렇게는 잘 사용하지 않음

		
		list.add("class"); list.add("interface"); list.add("inheritance");
		System.out.println(list);
		

	List<String> furitList = Arrays.asList(new String[] {"apple", "banana", "cherry"}); // new String 뻬면 에러
	System.out.println(furitList);
	// furitList.add("mango");  정적인 리스트, 추가/삭제불가능
	
	
	// 프리미티브 타입은 Wrapper 클래스로 리스트를 생성행 함
	List<Integer> numList = new ArrayList();
	numList.add(1); numList.add(3); numList.add(5);
	System.out.println(numList);
	
	// 추출(인뎅싱)
	System.out.println(list.get(1)); 		// (0) class, (1) interface, (2) inheritance
	
	// 데이터 추가
	list.add("list");				// 고정적으로 맨 뒤에 추가됨
	list.add(3, "collection");		// 3, " " = 3번 자리에 " " 이 다른 인덱스 앞에 추가됨
	System.out.println(list);
	list.addAll(furitList);			// 맨 뒷쪽에 푸르츠 리스트를 모두 추가
	System.out.println(list);
	
	// 데이터 변경
	list.set(5, "set"); 		// 원래 apple 자리였던 5번이 set 으로 바뀜
	System.out.println(list);
	
	
	// 데이터 삭제
	list.remove(6);				// 6번 인덱스 삭제		
	list.remove("cherry");		// cherry 값 삭제
	System.out.println(numList);
	numList.clear();			// 리스트 원소 자체 삭제
	
//	fruitList.add("mango") // 걍 망가짐
//	System.out.println(numList.size()); // 없는 값이기에 오류 발생
//	System.out.println(numList.isEmpty()); // 있는 값인지 없는 값인지 확인  - boolean
	
	
	
	// 정보 추출
	System.out.println(numList.isEmpty() + ", " + numList.size());
	System.out.println(list.contains("set") + ", " + list.indexOf("list") + ", " + list.indexOf("list2"));
	
	
	
	}

}
