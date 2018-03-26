package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import vitokenizer.VietnameseAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by khanh on 27/03/2018.
 */
public class LuceneTest {

    private final String indexDir = "src/main/resources/index";
    private final String data = "src/main/resources/sample.json";
    private final Analyzer analyzer = new VietnameseAnalyzer();


    public static void main(String[] args) {
        LuceneTest t = new LuceneTest();
//        t.createIndex();
        t.search("title", "Bán chung cư ngõ 162 Nguyễn Tuân, Thanh Xuân, Hà Nội");
    }

    public void createIndex() {
        try {
            Indexer indexer = new Indexer(indexDir, analyzer);
            indexer.addData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(String field, String q) {
        try {
            Directory d = new MMapDirectory(Paths.get(indexDir));
            Searcher s = new Searcher();
            s.search(field, q, analyzer, d);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
