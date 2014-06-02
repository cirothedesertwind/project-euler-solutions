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
public final class EulerSieve {

    public static final void main(String[] args) {
        EulerSieve e = new EulerSieve(10000000);

        for (int i = 0; i < 100; i++) {
            System.out.println(i + " is prime? " + e.isPrime(i));
        }

        System.out.println("There are " + e.primes() + " primes less than " + e.size());
    }

    private BitSet primes;
    private int size;

    public EulerSieve(int size) {
        this.size = size;

        primes = new BitSet(size);
        primes.flip(2, size);

        int i = 0;
        while (i < size) {
            if ((i = primes.nextSetBit(i)) == -1) {
                break;
            }
            //46340 is sqrt(2^31) which is out of range, therefore it can stop
            for (int j = i * i; (j < size && i < 46340); j += i) { 
                if (j < 0)
                    System.out.println("here");
                primes.set(j, false);
            }
            i++;
        }
    }

    public boolean isPrime(int index) {
        return primes.get(index);
    }

    public int primes() {
        return primes.cardinality();
    }

    private int size() {
        return size;
    }
}
