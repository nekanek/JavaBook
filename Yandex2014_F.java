import java.util.Scanner.*;
import java.util.Scanner;

public class Yandex2014_F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        

        String output = "";
        int LettersCount = 0;
 
        int i = 0;
        while (i < input.length()) {
            if (isLeftBraket(input.charAt(i))) {
                for (int j = i+1; j < input.length(); j++) {
                    if (isLetter(input.charAt(j))) {
                        LettersCount += 1;
                        if (j == input.length() -1) {
                            output += input.substring(i, j+1);
                            i = j+1;
                            break;
                        }
                    }
                    else if (isRightBraket(input.charAt(j)) && (LettersCount > 1)) {
                        output+= "<S>" + input.substring(i, j+1) + "</S>";
                        i = j+1;
                        break;
                    }
                    else {
                        output += input.substring(i, j+1);
                        i = j+1;
                        break;
                    }
                    
                }
            }   
            
            
            
            else if (isRightBraket(input.charAt(i))) {
                if (i==0) {
                    output += input.charAt(i);
                }
                else if ( (!isLetter(input.charAt(i-1))) && (!isDigit(input.charAt(i-1))) && (!isSpace(input.charAt(i-1))) && (!isLeftBraket(input.charAt(i-1))) && (!isRightBraket(input.charAt(i-1))) ){
                    output = output.substring(0,output.length()-1);
                    output += "<S>" + input.charAt(i-1) + input.charAt(i) + "</S>";
                
                }
                else {
                    output += input.charAt(i);
                }
                i++;
            }


            else {
                output += input.charAt(i);
                i ++;
            }
            
            
   
        }

        System.out.println(output);
    }
    
    private static boolean isLetter (char c){
    
        return Character.isLetter(c);
    
    }

    public static boolean isDigit (char c){
    
        return Character.isDigit(c);
    
    }
    public static boolean isLeftBraket (char c){
    
        return c == '(';
    
    }
    public static boolean isRightBraket (char c){
    
        return c == ')';
    
    }
    public static boolean isSpace (char c){
    
        return c == ' ';
    
    }

    
}
