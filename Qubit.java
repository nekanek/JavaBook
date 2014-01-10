/* 
4 Qubits. In quantum computing, a qubit plays the role of a bit. It is a complex number a + bi such that |a + bi| = 1. Once we measure a qubit, it "decides" to be a 1 with probability a^2 and a 0 with probability b^2. Any subsequent observations will always yield the same value. Implement a data type Qubit that has a constructor Qubit(a, b) and a boolean method observe that returns true or false with the proscribed probabilities.
*/

public class Qubit {
    
    private final Complex prob0;
    private final Complex prob1;
    private	boolean observed;
    private	int value;
	
    public Qubit(Complex a, Complex b) {
		// check validity of entered values
	
		if (!((a.times(a).plus(b.times(b)).re()==1d) && (a.times(a).plus(b.times(b)).im()==0d))) {
			throw new RuntimeException("Illegal qubit. Please, check that |a|^2 + |b|^2 = 1.");
		}

		else {
			prob0 = a;
			prob1 = b;
			observed = false;
		}
	}


    public String toString() {	
        return "(" + prob0.toString() + ") |0> + ("+ prob1.toString() + ") |1>.";
    }
    
    public boolean observe() {
		if (!observed) {
			observed = true;
			if ((prob1.times(prob1).re()>Math.random()) && (prob1.times(prob1).im()==0d)) value = 1;
			else value = 0;
		}
		if (value == 1) return true;
		else return false;
    }
    
    

    // sample client for testing
    public static void main(String[] args) {

	Qubit zero = new Qubit(new Complex(1d,0d), new Complex(0d,0d));
        Qubit one = new Qubit(new Complex(0d,0d), new Complex(1d,0d));
	
        System.out.println("Observed (1) qubit zero is " + zero.observe());
        System.out.println("Observed (2) qubit zero is " + zero.observe());
        System.out.println("Observed (1) qubit one is " + one.observe());	
        System.out.println("Observed (2) qubit one is " + one.observe());
	
	// uncomment this to run with test qubit
//	Qubit test = new Qubit(new Complex(Double.parseDouble(args[0]),Double.parseDouble(args[1])),new Complex(Double.parseDouble(args[2]),Double.parseDouble(args[3])));
//	for (int i=1; i<11; i++) System.out.println("Observed ("+i+") qubit test is " + test.observe());	    
	
    }
    


}
