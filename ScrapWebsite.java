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
		String url="http://www.wikipedia.com";
		
		/** Connect to the website and gets total links of URL*/
		Document doc = Jsoup.connect(url).get();  
		
		ScrapWebPage wp = new ScrapWebPage();
		/**display title*/
		wp.displayTitle(doc);	
		
		/**display all links on the main page*/
		//wp.displayAllInsideLinks(doc);	
		
		/**display number of links found on the page*/
		wp.countNumberOfLinksInside(doc);	
		
		/**display content of the page(for the moment it shows only text of the body of the page)*/
		wp.scrapPage(doc);
		
		/**scrap inside first 3 links found on the main page*/
		wp.scrapLinksInside(doc,3);
		
		/**/
	}

	
}
