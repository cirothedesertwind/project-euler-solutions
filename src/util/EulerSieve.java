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
public class EulerSieve {
   
     private BitSet primes;
     
     public EulerSieve(int size){
         primes = new BitSet(size);     
         primes.flip(2, size);
    
         int i = 0;
         while (i < size){
             if((i = primes.nextSetBit(i)) == -1) break;
             for (int j = i*i; j < size; j+=i){
                 primes.set(j, false);
             }
             i++;
         }
     }
     
     public boolean isPrime(int index){
         return primes.get(index);
     }
     
     public int primes(){
         return primes.cardinality();
     }
}
