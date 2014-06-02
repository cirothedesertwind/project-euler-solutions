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
        long[] d = PrimeSolver.factor(24);
        
        for (int i = 0; i < d.length;i++)
            System.out.println(d[i]);
    }
    
    //factors must be sorted.
    private static int divisors(long[] factors){
        int divisors = 1;
        int power = 0;
        long factor = 0;
        for (long f : factors){
            if (f != factor){
                divisors *= power;
                power = 1;
                factor = f;
            }
            else{
                power++;
            }
        }
        
        return divisors;
    }
}
