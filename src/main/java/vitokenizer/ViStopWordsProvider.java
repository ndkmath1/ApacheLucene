package vitokenizer;

import org.apache.lucene.analysis.CharArraySet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.lucene.util.Version;

/**
 * Created by khanh on 24/03/2018.
 */
public class ViStopWordsProvider {

    public static CharArraySet getStopWords(){
        String file = "src/main/resources/stopwords.txt";
        Set<String> stopWords = new HashSet<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                stopWords.add(line.replaceAll("_"," "));
                line = br.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return new CharArraySet(stopWords,true);
    }

}
