/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.BitSet;

/**
 *
 * @author Aurix
 */
public class SieveOfAtkin {
    private BitSet primes;

    public SieveOfAtkin(int max) {
        primes = new BitSet(max);
        
        primes.flip(2);
        primes.flip(3);
        primes.flip(5);
                
        for (int i = 0; i < max; i++){
            switch (i % 60){
                case 1:
                case 13:
                case 17:
                case 29:
                case 37:
                case 41:
                case 49:
                case 53:
                   break;
                case 7:
                case 19:
                case 31:
                case 43:
                    break;
                case 11:
                case 23:
                case 47:
                case 59:
                    break;
            }
        }
        
    }
    
    public boolean isPrime(int index){
        return primes.get(index);
    }
}
