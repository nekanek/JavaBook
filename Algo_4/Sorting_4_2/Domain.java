package JavaBook.Algo_4.Sorting_4_2;

public class Domain implements Comparable<Domain> {

    private static final String SEPARATOR = ".";
    // private static final int MAX_NUMBER_OF_LEVELS = 30;
    private String[] domainName;
    
    public Domain(String input) {
        // input = input.trim();
        
        String[] domain = input.split("\\.");
        if (domain.length == 0) {
            this.domainName = new String[1];
            this.domainName[0] = input;
        }
        else {
            this.domainName = new String[domain.length];
            for (int i = 0; i < domain.length; i++) {
                this.domainName[i] = domain[domain.length-1-i];            
            }
        }

    }
    
    @Override
    public int compareTo(Domain domain2) {
        int min = Math.min(this.domainName.length,
                        domain2.domainName.length);
        int result;
        for (int i = 0; i < min; i++) {
            if (!domainName[i].equalsIgnoreCase(domain2.domainName[i]))
                return domainName[i].compareToIgnoreCase(domain2.domainName[i]);
        }
        if (this.domainName.length == domain2.domainName.length)
            return 0;
        else if (this.domainName.length > domain2.domainName.length)    
            return 1;
        else return -1;
    }
    
    public void print() {
        for (int i = domainName.length - 1; i > 0 ; i--) {
            System.out.print(domainName[i] + ".");
        }
        System.out.println(domainName[0]);
    }

    public void printReversed() {
        System.out.print(domainName[0]);
        for (int i = 1; i < domainName.length; i++) {
            System.out.print("." + domainName[i]); 
        }
        System.out.println();
    }

}


