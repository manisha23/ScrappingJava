/**
 * 
 */
package scrappy;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Manisha
 *
 */
public class ScrapWebPage extends ScrapWebsite {

	/**
	 * 
	 */
	public ScrapWebPage() {
		// TODO Auto-generated constructor stub
		ScrapWebsite sw  = new ScrapWebsite();
		return;
	}
	
	public ScrapWebPage(Element link) {
		// TODO Auto-generated constructor stub
		Element l= link;
	}

	/**
	 * @param args
	 */
	
	
	public  void displayAllLinksInside(Document doc) throws IOException {
		/**Digs into the web page to find all links to other web pages */
		Elements links = doc.select("a[href]");   //finds links (a tags with href attributes)
		for (Element link : links) {  
		    System.out.println("\nlink : " + link.attr("href"));  
		    System.out.println("text : " + link.text());  
		    		}
	}
	
	public void countNumberOfLinksInside(Document doc) {
		Elements links = doc.select("a[href]");   //finds links (a tags with href attributes)
		int i=0;
		for (Element link : links) {  
		   i++;
		}
		System.out.println("Number of links found: "+i);
	}
	
	public  void displayTitle(Document doc) throws IOException {
		/*Displays the title of the page on console */
		String title = doc.title();  
        System.out.println("Title of the webpage is: " + title); 
	}
	
	public  void scrapPage(Document doc) throws IOException {
		/*Scraps inside the body of the web page */
		Element body = doc.body();
		String text = body.text();
		System.out.println("Text: " + text); 
	}
	
	public void scrapLinksInside(Document doc,int nblinks) throws IOException {
		int n = nblinks;
		Elements links = doc.select("a[href]");   //finds links (a tags with href attributes)
		int counter =0;
		for (Element link : links) {  
			if (counter < n ) {
				System.out.println("Link : "+counter);
				Document d= Jsoup.connect(link.attr("abs:href")).get();
				
				scrapPage(d);
				counter++;
			}
			else {
				System.out.println("Nothing more to show");
			}
		}
			
	}

	 private static void print(String msg, Object... args) {
	    System.out.println(String.format(msg, args));
	}
	
	private static String trim(String s, int width) {
	    if (s.length() > width)
	        return s.substring(0, width-1) + ".";
	    else
	        return s;
	}
	
	
	
}