package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import vitokenizer.VietnameseAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by khanh on 27/03/2018.
 */
public class Indexer {

    private Directory indexDir;
    private IndexWriterConfig config;

    public Indexer(String indexDirPath, Analyzer analyzer) throws IOException {
        indexDir = new MMapDirectory(Paths.get(indexDirPath));
        config = new IndexWriterConfig(analyzer);
    }

    public void addData(String filePath) throws IOException {
        IndexWriter writer = new IndexWriter(indexDir, config);
        DataConfig dataConfig = new DataConfig();
        List<RealEstate> results = dataConfig.getData(filePath);
        int i = 0;
        for (RealEstate r: results) {
            System.out.println("addDoc " + i);
            ++i;
            addDoc(writer, r);
            if (i == 10000) {
                break;
            }
        }
        writer.close();
    }

    private void addDoc(IndexWriter w, RealEstate r) throws IOException {
        Document d = new Document();
        d.add(new TextField("district", r.getDistrict(), Field.Store.YES));
        d.add(new TextField("province", r.getProvince(), Field.Store.YES));
//        d.add(new TextField("contactAddress", r.getContactAddress(), Field.Store.YES));
        d.add(new TextField("title", r.getTitle(), Field.Store.YES));
        d.add(new TextField("categoryName", r.getCategoryName(), Field.Store.YES));
//        d.add(new TextField("projectName", r.getProjectName(), Field.Store.YES));
//        d.add(new TextField("projectInvestor", r.getProjectInvestor(), Field.Store.YES));
//        d.add(new TextField("projectSize", r.getProjectSize(), Field.Store.YES));
//        d.add(new TextField("address", r.getAddress(), Field.Store.YES));
        d.add(new TextField("description", r.getDescription(), Field.Store.YES));
        w.addDocument(d);
    }

}
