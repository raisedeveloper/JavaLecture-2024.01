package extra_crawling.sec01_human_edu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Ex01_HumanEdu {

	public static void main(String[] args) throws IOException {
		String url = "https://human.or.kr/";
		Document doc = Jsoup.connect(url).get();

		// 1개의 엘리먼트
		Element strong = doc.selectFirst(".f_right > strong");
		System.out.println(strong.text());

		Element address = doc.selectFirst(".f_left > address");
//        System.out.println(address.html());
		String[] addressArray = address.html().split("<br>");
//        for (String add : addressArray)
//            System.out.println(addr.strip());
		List<String> addressList = new ArrayList<>();
		for (String addr : addressArray) {
			addressList.add(addr.strip());
		}
		addressList.forEach(x -> System.out.println(x));

		// 한글 주소는 인코딩되어서 보임
		// url = "https://www.human.or.kr/program?sca=%EC%88%98%EC%9B%90";
		url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode("수원", "utf-8");
		doc = Jsoup.connect(url).get();

		// 여러개의 엘리먼트
		Elements lis = doc.select(".dp_li.num-1");
		System.out.println(lis.size());

//        Element li = lis.get(0);	// lis 여러개중에 첫번째 li
//        String title = li.selectFirst(".txt_wrap > h2").text().strip();
//        String desc = li.selectFirst(".txt_content").text().strip();
//        System.out.println(title);
//        System.out.println(desc);

//        for (Element li: lis) {
//        	String title = li.selectFirst(".txt_wrap > h2").text().strip();
//          String desc = li.selectFirst(".txt_content").text().strip();
//          System.out.println(title);
//          System.out.println(desc);
//          System.out.println("==============================================================");

		// 서울, 수원, 천안의 과정을 출력
		for (String place : new String[] { "서울", "수원", "천안" }) {
			url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode(place, "utf-8");
			doc = Jsoup.connect(url).get();

			Elements lis1 = doc.select(".dp_li.num-1");
			System.out.println(place + " 과정수: " + lis1.size());

			for (Element li : lis1) {
				String title = li.selectFirst(".txt_wrap > h2").text().strip();
				String desc = li.selectFirst(".txt_content").text().strip();
				System.out.println(title);
				System.out.println(desc);

				System.out.println("==============================================================");

			}
		}

	}
}