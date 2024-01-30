package extra_api;

import ch12_interface.sec05_default.B;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RoadAddrApi {
	public String getRoadAddr(String keyword) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(("C:/Temp/roadApiKey.txt")));
		String confmKey = br.readLine();
		br.close();
		int currentPage = 1, countPerPage = 5;
		String resultType = "json";
		keyword = URLEncoder.encode(keyword, "utf-8");
		String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do" + "?confmKey=" + confmKey + "&currentPage="
				+ currentPage + "&countPerPage=" + countPerPage + "&resultType=" + resultType + "&keyword=" + keyword;

		URL url = new URL(apiUrl);
		br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String tempStr = null;

		while (true) {
			tempStr = br.readLine();
			if (tempStr == null)
				break;
			sb.append(tempStr); // 응답결과 JSON 저장
		}
		br.close();

		// JSON 데이터에서 원하는 값 추출하기
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(sb.toString()); // 여기까지는 보고 쓸 수 밖에 없음
		JSONObject results = (JSONObject) object.get("results"); // 리턴 벨류가 오브젝트
		JSONArray juso = (JSONArray) results.get("juso");
		JSONObject jusoItem = (JSONObject) juso.get(0); // 주소의 첫번째 값 주소의 오브잭트 = 맵
//		System.out.println(juso.size());   
		String roadAddr = (String) jusoItem.get("roadAddr");

		return roadAddr;
	}
}
