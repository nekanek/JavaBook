// checks whether there's a new chapter of Fish eye placebo by yuumei on deviantart. (yet should change name each time)

package JavaBook.misc;
import JavaBook.stanfStd.*;

public class Checkfep {

   // get HTML
   public static String readHTML() {
       In page = new In("http://yuumei.deviantart.com/gallery/42604730");
       String html = page.readAll();
       return html;
   }

   // Check whether there's new chapter
   public static String checkPart1(String html) {
       int from     = html.indexOf("href=\"http://yuumei.deviantart.com/art/Fisheye-Placebo-Ch1-Part-1", 0); 
       if (from==-1) { 
	   return "No new chapter (1) yet. V_V ";
       }
       int to    = html.indexOf("\" title=\"", from); 
       String url = html.substring(from + 6, to);
       return "There is! Here is url: " + url;
   }

   public static String checkPart2(String html) {
       int from     = html.indexOf("href=\"http://yuumei.deviantart.com/art/Fisheye-Placebo-Ch1-Part-2", 0); 
       if (from==-1) { 
	   return "No new chapter (2) yet. V_V ";
       }
       int to    = html.indexOf("\" title=\"", from); 
       String url = html.substring(from + 6, to);
       return "There is! Here is url: " + url;
   }

   public static void main(String[] args) {

       String html = readHTML();
       StdOut.println(checkPart1(html));
       StdOut.println(checkPart2(html));
   }

}
