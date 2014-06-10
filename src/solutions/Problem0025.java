/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.math.BigInteger;

/**
 *
 * @author Luke Petrolekas
 */
public class Problem0025 {

    public static void main(String[] args) {
       
        BigInteger m = BigInteger.ONE; // First term
        BigInteger n = BigInteger.ONE; // Second term
        BigInteger p;
        
        int term = 2; //We're at the second term, then iterate per term.

        while (n.toString().length() < 1000) {
            p = n;
            n = n.add(m);
            m = p;
            term++;
        }

        System.out.println(term);

    }

}
