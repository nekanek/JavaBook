package JavaBook.genome;
import JavaBook.stanfStd.*; 		

public class upTest {

    public static void main(String[] args) {
	
        char a = 'a';
		char Aa = 'A';
	
	if (Character.isUpperCase(Aa)  && !(Character.isUpperCase(a))) {
	    StdOut.println("is Upper case is working" );
	}
	
	else {
	    StdOut.println("is Upper case doesnt work" );
	}
		
	char a1 = Character.toUpperCase(a);
	StdOut.println("uppercasing a: "+ a1 );

    if (a1 == Aa) {
        StdOut.println("A == uppercased a " );
	}
	else {
        StdOut.println("A != a " );
	}
	
	
    }
}