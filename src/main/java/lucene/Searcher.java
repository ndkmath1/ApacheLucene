package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;

import java.io.IOException;

/**
 * Created by khanh on 27/03/2018.
 */
public class Searcher {

    public void search(String field, String query, Analyzer analyzer, Directory indexDir) throws ParseException, IOException {
        Query q = new QueryParser(field, analyzer).parse(query);
        int hitsPerPage = 100;
        IndexReader reader = DirectoryReader.open(indexDir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get(field));
        }
        reader.close();
    }

    public void searchHighlight(String field, String queryStr, Analyzer analyzer, Directory indexDir) throws ParseException, IOException, InvalidTokenOffsetsException {
        Query query = new QueryParser(field, analyzer).parse(queryStr);
        int hitsPerPage = 100;
        IndexReader reader = DirectoryReader.open(indexDir);
        IndexSearcher searcher = new IndexSearcher(reader);
        //Search the lucene documents
        TopDocs hits = searcher.search(query, hitsPerPage);

        /** Highlighter Code Start ****/

        //Uses HTML &lt;B&gt;&lt;/B&gt; tag to highlight the searched terms
        Formatter formatter = new SimpleHTMLFormatter();

        //It scores text fragments by the number of unique query terms found
        //Basically the matching score in layman terms
        QueryScorer scorer = new QueryScorer(query);

        //used to markup highlighted terms found in the best sections of a text
        Highlighter highlighter = new Highlighter(formatter, scorer);

        //It breaks text up into same-size texts but does not split up spans
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer, 10);

        //breaks text up into same-size fragments with no concerns over spotting sentence boundaries.
        //Fragmenter fragmenter = new SimpleFragmenter(10);

        //set fragmenter to highlighter
        highlighter.setTextFragmenter(fragmenter);

        //Iterate over found results
        for (int i = 0; i < hits.scoreDocs.length; i++)
        {
            int docid = hits.scoreDocs[i].doc;
            Document doc = searcher.doc(docid);
            String title = doc.get("path");

            //Printing - to which document result belongs
            System.out.println("Path " + " : " + title);

            //Get stored text from found document
            String text = doc.get(field);

            //Create token stream
            TokenStream stream = TokenSources.getAnyTokenStream(reader, docid, field, analyzer);

            //Get highlighted text fragments
            String[] frags = highlighter.getBestFragments(stream, text, 10);
            for (String frag : frags)
            {
                System.out.println("=======================");
                System.out.println(frag);
            }
        }
        indexDir.close();
    }

}
