package demo.lucene;

import java.io.IOException;
import java.nio.file.FileSystems;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneOnDisk {
    public static void main(String[] args) throws IOException, ParseException {
    
    	LuceneOnDisk inmemory = new LuceneOnDisk();
        String querystr = args.length > 0 ? args[0] : "lucene";
    	try {
    		inmemory.luceneTest(querystr);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void luceneTest(String querystr) throws IOException, ParseException {
    	// 0. Specify the analyzer for tokenizing text.
        //    The same analyzer should be used for indexing and searching
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // 1. create the index
        String dir = "G:/dev/lucene-store1";
        FSDirectory index = FSDirectory.open(FileSystems.getDefault().getPath(dir));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        IndexWriter w = new IndexWriter(index, config);
        IndexReader reader = DirectoryReader.open(index);
       for(String[] book:books) {
	        //if(!docExists(reader, analyzer, book[1])) 
	        {
		        addDoc(w, book[0], book[1]);
	        	System.out.println("ISBN "+book[1]+" not exists, added");
	        }
	        //else 
	        {
	        	System.out.println("ISBN "+book[1]+" already exists, skipped");
	        }
        }
		
        // 2. query
        Query q = new QueryParser("title", analyzer).parse(querystr);

        // 3. search
        int hitsPerPage = 10;
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        // 4. display results
        System.out.println("Found " + hits.length + " hits.");
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + docId + ", " + d.get("isbn") + ", " + d.get("title"));
        }

        // reader can only be closed when there
        // is no need to access the documents any more.
        reader.close();
    }

    private void addDoc(IndexWriter w, String title, String isbn) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        // use a string field for isbn because we don't want it tokenized
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }
    private boolean docExists(IndexReader reader, Analyzer analyzer, String isbn) throws IOException, ParseException {

    	System.out.println("Num of docs:"+reader.numDocs());
    	if(reader.numDocs()<1) return false;
        int hitsPerPage = 10;
        Query q = new QueryParser("isbn", analyzer).parse(isbn);
        
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        return hits.length>0? true:false;
    }
    
    // data
    private String[][] books = {
    		{ "Lucene in Action", "193398817" },
    		{ "Lucene for Dummies", "55320055"},
	        { "Managing Gigabytes", "55063554"},
	        { "The Art of Computer Science", "9900333" }
    };
}