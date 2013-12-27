/* 
Dates. Create a data type Date that represents a date. You should be able to create a new Date by specifying the month, day, and year. It should supports methods to compute the number of days between two dates, return the day of the week that a day falls on, etc. 
*/

public class Date {
    private final String mm;  
    private final String dd;   
	  private final String year;
	
    public Date(String mm, String dd, String year)
	{
		// check validity of entered date
		if ((mm<1)||(mm>12)||(dd<1)||(dd>31)||(((mm=="02")||(mm=="2"))&&(((dd>29)&&(year%4==0))||((dd>28)&&(year%4!=0))))||(year<0)) {
			throw new RuntimeException("Illegal date. Please, check.");
		}
		else if (divisor<0) {
			p = -dividend; // works both for -p/-q and p/-q
			q = -divisor;
		}
		else {
			p = dividend; 
			q = divisor;	
		}
	}

    // return a string representation of the invoking Rational object
    public String toString() {
		/*         if (q == 0) { 
			double inf = Double.POSITIVE_INFINITY; 
			return Double.toString(inf);
		} */
		if (p == 0) return "0";
		else if (q==1) return ""+p;
        else return p + "/" + q;
    }

     // return a + b   
    public Rational plus(Rational b) {
        long dividend = p*b.q + q*b.p;
        long divisor = q*b.q;
		Rational c = new Rational(dividend, divisor);
		return c.reduce();
    }

    // return a - b
    public Rational minus(Rational b) {
        long dividend = p*b.q - q*b.p;
        long divisor = q*b.q;
		Rational c = new Rational(dividend, divisor);
		return c.reduce();
    }

    // return a * b
    public Rational times(Rational b) {
        long dividend = p*b.p;
        long divisor = q*b.q;
		Rational c = new Rational(dividend, divisor);
		return c.reduce();
    }

    // return a / b
    public Rational divide(Rational b) {
        long dividend = p*b.q;
        long divisor = q*b.p;
		Rational c = new Rational(dividend, divisor);
		return c.reduce();
    }

    // return the dividend or divisor
    public double p() { return p; }
    public double q() { return q; }

	

    // raising to a power
    public Rational power(int x) {
    	Rational c = new Rational((long)Math.pow(p,x), (long)Math.pow(q,x));
		return c.reduce();
	}
	

/*     public Rational root(int x) {
        return new Complex(Math.power(p,1/x), Math.power(q,1/x));
    } */
	
	
    // return value of e^Rational
    public Double exp() {
		//Double e = Math.pow(Math.E,p/q);
        return Math.pow(Math.E,(p/q));
    }

	// absolute value of a number
    public Rational abs() {
		if (p>=0) return  new Rational(p,q);
		else return  new Rational(-p,q);
    }	
	
    // return a double value sin(Rational)
    public Double sin() {
        return Math.sin(p/q);
    }

    // return a double value sin(Rational)
    public Double cos() {
        return Math.cos(p/q);
    }

    // return a double value sin(Rational)
    public Double tan() {
        return sin()/cos();
    }
	

	// return a new Rational object whose value is reduced value of the same rational
    public Rational reduce() {
		// find the greatest common divisor
		long Min = Math.min(Math.abs(p), q);
		for (long i = Min; i>0; i--) {
			if  (((q%i)==0)&&((p%i)==0)) 
				return new Rational(p/i, q/i);	
		}
		Rational a = new Rational(p, q);
		return a;
    }   
	
    // return true if both denominator and divisor are equivalent for two objects	
	public boolean equals(Rational b) {
        return (p==b.p&&q==b.q);
    }    

    // sample client for testing
    public static void main(String[] args) {
        Rational a = new Rational(1, 1);
        Rational b = new Rational(-4, 9);

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
 
        System.out.println("b + a        = " + b.plus(a));
		System.out.println("a - b        = " + a.minus(b));
        System.out.println("a * b         = " + a.times(b));
        System.out.println("a / b         = " + a.divide(b));
		
		System.out.println("a equals b is " + b.equals(a));
		System.out.println("toString method check: a is "+ a.toString());

        System.out.println("dividend of b = " + b.p());
        System.out.println("divisor of a  = " + a.q());
        System.out.println("a ^ 3         = " + a.power(3));		
        System.out.println("e ^ a         = " + a.exp());	      
        System.out.println("|a|          = " + a.abs());

        System.out.println("sin(a)       = " + a.sin()); 
        System.out.println("cos(a)       = " + a.cos()); 
        System.out.println("tan(a)       = " + a.tan()); 		
    }

}
