/* 
4 Qubits. In quantum computing, a qubit plays the role of a bit. It is a complex number a + bi such that |a + bi| = 1. Once we measure a qubit, it "decides" to be a 1 with probability a^2 and a 0 with probability b^2. Any subsequent observations will always yield the same value. Implement a data type Qubit that has a constructor Qubit(a, b) and a boolean method observe that returns true or false with the proscribed probabilities.
*/

public class Qubit {
    
    private final Complex q;
	private final boolean observed;
	private final int value;
	
    public Qubit(int a, int b)
	{
		// check validity of entered values
		if (!((a*a + b*b)==1)) {
			throw new RuntimeException("Illegal qubit. Please, check that |a + bi| = 1.");
		}

		else {
			q = new Complex (a, b);
			observed = false;
		}
	}


    public String toString() {	
        return Complex.re() + " + "+ Complex.im() + "i.";
    }
    
    public boolean observe() {
		if (!observed) {
			observed = true;
			if (Math.random() <= re()*re()) value = 1;
			else value = 0;
		}
		if (value == 1) return true;
		else return false;
    }
    
    

    // sample client for testing
    public static void main(String[] args) {
        Qubit zero = new Qubit(1, 0);
        Qubit one = new Qubit(0, 1);
		Qubit test = new Qubit(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	
        System.out.println("Observed (1) qubit zero is " + zero.observe());
        System.out.println("Observed (1) qubit one is " + one.observe()); 
        System.out.println("Observed (2) qubit zero is " + zero.observe());
        System.out.println("Observed (2) qubit one is " + one.observe());
        System.out.println("Observed (1) qubit test is " + test.observe());
        System.out.println("Observed (2) qubit test is " + test.observe());		
    }
    


}
