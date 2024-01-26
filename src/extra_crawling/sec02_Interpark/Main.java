package extra_crawling.sec02_Interpark;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		InterpartkBookService interparkBookService = new InterpartkBookService();
		List<InterparkBook> list = interparkBookService.getBestSeller();
		list.forEach(x -> System.out.println(x));

	}

}
