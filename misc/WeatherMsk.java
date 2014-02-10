
package JavaBook.misc;
import JavaBook.stanfStd.*;

public class WeatherMsk {

   // get HTML
   public static String readHTML() {
       In page = new In("http://www.gismeteo.ru/city/hourly/4368/#wdaily1");
       String html = page.readAll();
       return html;
   }

   // get degrees value
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
