package JavaBook.genome;
import JavaBook.stanfStd.*; 		

public class shiftTest {

    public static void main(String[] args) {
	
        int a = 0b0000_0000_0000_0000;
        int b = 0b11;
        int c = 0b10;
//10000001 | 1 << 5 = 1010000 // turn bit on
        //01010101 & ~(1<<2) // turn bit off
        a = a | b << 6-1;
        a = a | c << 1-1;
        
	    System.out.println("b is " + Integer.toBinaryString(a));
        
        int i =17;
        int quotient = (int)(i/16);
        int remainder = 2*(i-16*quotient);
        int remainder2 = 2*(i%16); 
        System.out.println("remainder 1 is  " + remainder);
        System.out.println("remainder 2 is " + remainder2);
        
        int _values = 5;
        
        int lastIndex = 2*((_values-1)%16);
        
        System.out.println("lastIndex is " + lastIndex);
	}
}