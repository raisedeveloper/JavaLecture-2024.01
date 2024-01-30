package extra_api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 *  도로명주소로부터 위도(latitude), 경도(longitude) 정보를 구해주는 메소드
 */
public class KakaoLocalApi {
	
	public Map<String, Double> getGeocod(String addr) throws Exception {
	BufferedReader br = new BufferedReader (new FileReader("c:/Temp/roadApiKey.txt"));
	String kakaoKey = br.readLine();
	br.close();
	String query = URLEncoder.encode(addr, "utf-8");
	String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json"
					+ "?query=" + query;
	
	URL url = new URL(apiUrl);
	
	// 헤더 설정 하기
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestProperty("Authorization", "KakaoAK "+ kakaoKey);
	
	return null;
}
}