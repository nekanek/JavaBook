import java.util.Scanner.*;
import java.util.Scanner;

public class Yandex2014_F {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        

        String output = "";
        int LettersCount = 0;
 
        int i = 0;
        while (i < input.length()) {
            if (isLeftBraket(input.substring(i, i+1))) {
                for (int j = i+1; j < input.length(); j++) {
                    if (isLetter(input.substring(j, j+1))) {
                        LettersCount += 1;
                        if (j == input.length() -1) {
                            output += input.substring(i, j+1);
                            i = j+1;
                            break;
                        }
                    }
                    else if (isRightBraket(input.substring(j, j+1)) && (LettersCount > 1)) {
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
            
            
            
            else if (isRightBraket(input.substring(i, i+1))) {
                if (i==0) {
                    output += input.substring(i, i+1);
                } 
                else if ( (!isLetter(input.substring(i-1, i))) && (!isDigit(input.substring(i-1, i))) && (!isSpace(input.substring(i-1, i))) &&  (!isLeftBraket(input.substring(i-1, i))) &&  (!isRightBraket(input.substring(i-1, i))) ){
                    output = output.substring(0,output.length()-1);
                    output += "<S>" + input.substring(i-1, i) +  input.substring(i, i+1) + "</S>";
                
                }
                else {
                    output += input.substring(i, i+1);
                }
                i++;
            }


            else {
                output += input.substring(i, i+1);
                i ++;
            }
            
            
   
        }

        System.out.println(output);
    }
    
    private static boolean isLetter (String c){
    
        return Character.isLetter(c.charAt(0));
    
    }

    public static boolean isDigit (String c){
    
        return Character.isDigit(c.charAt(0));
    
    }
    public static boolean isLeftBraket (String c){
    
        return (c.charAt(0)) == '(';
    
    }
    public static boolean isRightBraket (String c){
    
        return (c.charAt(0)) == ')';
    
    }
    public static boolean isSpace (String c){
    
        return (c.charAt(0)) == ' ';
    
    }    

    
}
