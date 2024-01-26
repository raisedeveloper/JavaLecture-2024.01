package extra_crawling.sec03_melon_chart;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import extra_crawling.sec02_Interpark.InterparkBook;

public class melonChartService {

	public List<MelonChart> getBestMelonChart() {
		String url = "https://www.melon.com/chart/index.htm";
		 Document doc = Jsoup.connect(url).get();
		 Elements lis = doc.select(".rankBestContentList > ol > li");
		 List<MelonChart> list = new ArrayList<>();
		 
		 for (Element li : lis) {		// 하나씩 꺼내겠다
		 
        String rank_ = li.selectFirst(".rank").text().strip();
        String title = li.selectFirst(".title").text().strip();
        String artist = li.selectFirst(".artist").text().strip();
        String album = li.selectFirst(".album").text().strip();
        String like_ = li.selectFirst(".like").text().strip();
        int like = Integer.parseInt(like_.replace(",", ""));
        int rank = Integer.parseInt(rank_.replace(",", ""));
            MelonChart mc = new MelonChart(rank, title, artist, album, like);
            list.add(mc);
        }
}
        return list;
    }

/* 배열이라는게 처음부터 끝까지 자료를 관리하는 것
 * 책장에 책을 꽂아놓았을 때 하나하나 꺼낸다는 의미임 
 * 꺼내는 것을 로봇에게 시키고 싶음 귀찮아서
 * 그래서 배열에다가 반복문을 돌리는 거다
 * Enhanced for loop for문으로 배열에서 자료 하나하나 꺼내는 법 [i]  
 * 
 * new 배열[배열의 자릿수];
 * int i = 0; i < 배열의 길이; i++
 * {
 * 	배열 변수 = 배열[i];
 * 배열변수.메소드~~~~();
 * 
 * for (자료형 변수이름: 배열){
 * 	변수이름.메소드~~~~();
 * }
 * 
 * }
 * */
