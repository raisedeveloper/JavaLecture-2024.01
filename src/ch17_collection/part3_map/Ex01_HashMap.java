package ch17_collection.part3_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex01_HashMap {

	public static void main(String[] args) {
		// 해쉬 맵
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 주로 첫번째는 'String'이 많이 옴 new 로 구현 객체 만들것

		map.put("사과", 1500);
		map.put("배", 2500);
		map.put("감", 1000);
		map.put("배", 3000);
		// 'key'값 'value'값 들어감
		
		// 추출
		System.out.println(map.get("사과"));	// key로 값 얻기
		
		// 정보 추출
		System.out.println(map.containsKey("배") + ", " + map.containsValue(4000));
		
		// 'key set'으로부터 정보추출 하는 법 "key의 Set collection - 이 방법을 권장함"
		Set<String> keySet = map.keySet();
		for (String key: keySet)
			System.out.println(key + ", " + map.get(key));

	
	
	
	}

}
