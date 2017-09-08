package scrappy;
/**
 * @author Manisha
 *
 */
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ScrapWebsite {
	/**
	 * This class scraps into a website which may or may not contain many webpages 
	 */
	public ScrapWebsite() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) throws IOException {
		String url="http://www.meilleursagents.com";
		
		/** Connect to the website and gets total links of URL*/
		Document doc = Jsoup.connect(url).get();  
		
		ScrapWebPage wp = new ScrapWebPage();
		wp.displayTitle(doc);
		//wp.displayAllInsideLinks(doc);
		wp.countNumberOfLinksInside(doc);
		wp.scrapPage(doc);
		
		
		/**/
	}

	
}
