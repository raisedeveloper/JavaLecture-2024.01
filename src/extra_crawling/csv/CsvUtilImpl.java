package extra_crawling.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtilImpl implements CsvUtil {

	@Override
	public List<List<String>> readCsv(String filename) {
		return readCsv(filename, ",", 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator) {
		return readCsv(filename, separator, 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, int skipLine) {
		return readCsv(filename, ",", skipLine);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator, int skipLine) {
		List<List<String>> csvList = new ArrayList<List<String>>();
		BufferedReader br = null;
		int lineNo = 0;
		try {
			br = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (skipLine > lineNo++)
					continue; // 데이터를 갖다 붙이지 말고 몇줄 띄어라 >> 컨티뉴~~~~
				String[] lineArray = line.split(separator);
				csvList.add(Arrays.asList(lineArray)); // 리스트 한줄이면 됨 (쉬운 방법, 이하 4줄과 기능이 같음)
//				List<String> lineList = new ArrayList<String>();	// 여러줄로 코딩하는 법 (힘든 방법)
//				for (String word: lineArray)
//					lineList.add(word);
//				csvList.add(lineList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return csvList;
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList) {
		writeCsv(filename, dataList, ",");
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList, String separator) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			for (List<String> data : dataList) {
				String line = "";
				for (int i = 0; i < data.size(); i++) {
					line += data.get(i);
					if (i < data.size() - 1)
						; // 하나 뺀 값보다 적으면 하나 추가?
					line += separator;
				}
				bw.write(line + "\n");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}