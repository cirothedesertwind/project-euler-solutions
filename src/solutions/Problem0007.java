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
      
    private static final int VALUE = 10; //magic number empirically determined
    
    public static void main(String[] args){
        EulerSieve e = new EulerSieve(VALUE);
        for (int i = 0; i < VALUE; i++){
            if (e.isPrime(i)){
                    System.out.println(i);
            }
            
        }
    }
}
