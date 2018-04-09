package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import vntokenizer.VietnameseAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by khanh on 27/03/2018.
 */
public class LuceneTest {

    private final String indexDir = "src/main/resources/index";
    private final String data = "src/main/resources/sell_detail.json";
    private final Analyzer analyzer = new VietnameseAnalyzer();


    public static void main(String[] args) {
        LuceneTest t = new LuceneTest();
//        t.createIndex();
//        t.search("title", "Bán chung cư ngõ 162 Nguyễn Tuân, Thanh Xuân, Hà Nội");
        try {
            t.searchMultiField("Bán chung cư ngõ 162 Nguyễn Tuân");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void searchMultiField(String qs) throws ParseException, IOException {
        String[] fields = {"title", "description"};
        MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, analyzer);
        parser.setDefaultOperator(QueryParser.Operator.OR);
        Query q = parser.parse(qs);
        Searcher searcher = new Searcher();
        searcher.searchMulti(q, new MMapDirectory(Paths.get(indexDir)));
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
            s.searchHighlight(field, q, analyzer, d);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InvalidTokenOffsetsException e) {
            e.printStackTrace();
        }
    }

}
