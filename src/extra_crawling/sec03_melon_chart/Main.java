package extra_crawling.sec03_melon_chart;

import java.io.IOException;
import java.util.List;

public class Main {
	
		public static void main(String[] args) throws IOException {
			MelonchartService melonchartService = new MelonchartService();
			List<Melonchart> list = MelonchartService.getchart();
			list.forEach(x -> System.out.println(x));

	}

}
