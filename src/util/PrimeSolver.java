package util;

import java.util.Arrays;

/**
 * A very simple prime number solver.
 *
 * License: MIT
 */
public final class PrimeSolver {

    public static void main(String[] args){
        for (long prime : factor(21))
            System.out.println(prime);
    }

    public static long[] factor(long n){
        LongVector v = new LongVector();
        //use fermat factorization on the remaining odd part
        v.addElements(factorFermat(n));
        long[] copy = Arrays.copyOf(v.array(), v.array().length);
        Arrays.sort(copy);
        return copy;
    }


    /* http://en.wikipedia.org/wiki/Fermat's_factorization_method */
    private static long[] factorFermat(long n){
        int count2s = 0;
        //make the number odd
        while (n % 2 == 0){
            n = n / 2;
            count2s++;
        }
        
        //Create array of twos
        long[] twosArray = new long[count2s];
        Arrays.fill(twosArray, 2);
        
        //Handle odd part

        long a = (long)Math.ceil(Math.sqrt(n));
        long b2 = a*a - n;

        while (Math.sqrt(b2) != Math.floor(Math.sqrt(b2))){
            a++;
            b2 = a*a - n;
        }
        
       
        long x = a - (long)Math.sqrt(b2);
        long y = a + (long)Math.sqrt(b2);

        if (x == 1 || y == 1)
            if (x == 1)
                return ArrayUtil.union(twosArray, new long[]{y});
            else
                return ArrayUtil.union(twosArray, new long[]{x});
        
        return ArrayUtil.union(twosArray, 
                ArrayUtil.union(factorFermat(x), factorFermat(y)));
    }


    public static long[] getPrimes(long n){
        LongVector l = new LongVector();
        for (int i = 2; i < n;i++)
            if (isPrime(i))
                l.addElement(i);

        return l.array();
    }

    public static boolean isPrime(long n){
        if (n < 2)
            return false;

        long squareRoot = (long)Math.floor(Math.sqrt(n));
        for (int i = 2; i<=squareRoot;i++){
            if (n % i == 0) return false;
        }

        return true;
    }
}