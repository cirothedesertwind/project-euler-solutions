package solutions;

import util.PrimeSolver;

/*
 * Project Euler Solution
 * Problem 0012
 * @author Luke Petrolekas
 *
 * License: MIT
 */
public class Problem0012 {
    
    public static void main(String[] args){
        int divisors = 1;
        long n = 0L;
        for (int i = 1; divisors < 501; i++){
             n = (i*(i+1))/2;
             long[] pf = PrimeSolver.factor(n);
             divisors = tauCounter(pf);
             System.out.println("Triangle number " + i + ", "+ n + " = " + divisors);
        }
    }
    
    //factors must be sorted.
    private static int tauCounter(long[] factors){
        int c = 1;
        long comparator = -1;
        int divisors = 1;
        for (long prime : factors){
            if (prime == comparator){
                c++;
            }else{
                //new prime number;
                divisors *= (c+1);                
                c=1;
                comparator = prime;
            }
            
        } 
        
        return divisors;
    }
}
