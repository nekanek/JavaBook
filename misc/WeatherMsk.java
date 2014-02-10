/*************************************************************************
 *  Compilation:  javac StockQuote.java
 *  Execution:    java StockQuote symbol
 *  Dependencies: In.java, StdOut.java
 *
 *  Print the stock price of the stock with the given symbol. Screen scrapes
 *  finance.yahoo.com<http://finance.yahoo.com> to get the current price and
 *  associated information.
 *
 *  % java StockQuote goog
 *  1100.62
 *  Google Inc.
 *  Sun, Dec 22, 2013, 6:04AM EST 
 *
 *  % java StockQuote aapl
 *  549.02
 *  Apple Inc.
 *  Sun, Dec 22, 2013, 6:04AM EST 
 * 
 *  % java StockQuote ibm
 *  180.02
 *  International Business Machines
 *  Sun, Dec 22, 2013, 6:04AM EST 
 *
 *  % java StockQuote msft
 *  36.80
 *  Microsoft Corporation
 *  Sun, Dec 22, 2013, 6:04AM EST 
*
*************************************************************************/
package JavaBook.misc;
import JavaBook.stanfStd.*;

public class WeatherMsk {

   // Given symbol, get HTML
   public static String readHTML() {
       In page = new In("http://www.gismeteo.ru/city/hourly/4368/#wdaily1");
       String html = page.readAll();
       return html;
   }

   // Given symbol, get current stock price.
   public static String degrees(String html) {
       int p1     = html.indexOf("<h3 class=\"typeC\">Москва</h3>", 0); // <h3 class="typeC">Москва</h3> index
       int p = html.indexOf("<dd class='value m_temp c", p1); // <dd class='value m_temp c
       int from  = html.indexOf(">", p);            // ">" index
       int to    = html.indexOf("<span class=\"meas\">", from);   // "</span>" index
       String degrees = html.substring(from + 1, to);
       return degrees.replaceAll("&minus;", "-");
   }


   public static String wind(String html) {
       int p1     = html.indexOf("<h3 class=\"typeC\">Москва</h3>", 0); // <h3 class="typeC">Москва</h3> index
       int p = html.indexOf("<dd class='value m_wind ms", p1); // <dd class='value m_wind ms
       int from  = html.indexOf(">", p);            // ">" index
       int to    = html.indexOf("<span class=\"unit\">", from);   // "</span>" index
       String windPower = html.substring(from + 1, to);
       
       
       from  = html.indexOf("=\"unit\">", p);   
       to    = html.indexOf("</span>", from);   
       String windUnit = html.substring(from + 8, to);
       
       p = html.indexOf("value m_wind kmh", p1);
       from  = html.indexOf("<dt>", p);            
       to    = html.indexOf("</dt>", from);        
       String windDirection = html.substring(from + 4, to);
       
       return windPower + " "+ windUnit + "("+ windDirection + ")";       

   }




   public static void main(String[] args) {

       String html = readHTML();
       StdOut.println("Currently in Moscow:");
       StdOut.println(degrees(html));
       StdOut.println(wind(html));

   }

}
