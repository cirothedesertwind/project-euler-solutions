package solutions;

import util.EulerSieve;

/**
 * Project Euler Solution
 * Problem 0007
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0007 {
      
    private static final int VALUE = 10000000; //magic number empirically determined
    private static final int TARGET = 10001;
    
    public static void main(String[] args){
        EulerSieve e = new EulerSieve(VALUE);
        
        int count = 0;
        int index = -1;
        
        for (int i = 0; i < VALUE && count < TARGET; i++)
            if (e.isPrime(i)){
                count++;
                index = i;
            }
        
        System.out.println(index);
    }
}
