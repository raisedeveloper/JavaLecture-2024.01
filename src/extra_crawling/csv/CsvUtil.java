package extra_crawling.csv;

import java.util.List;

public interface CsvUtil {
    // separator 기본값은 ",", skipLine 기본값은 0
    // 문자열 단위와 줄단위로 각각 리스트
    List<List<String>> readCsv(String filename);

    List<List<String>> readCsv(String filename, String separator);

    List<List<String>> readCsv(String filename, int skipLine);

    List<List<String>> readCsv(String filename, String separator, int skipLine);


    void writeCsv(String filename, List<List<String>> dataList);

    void writeCsv(String filename, List<List<String>> dataList, String separator);


}