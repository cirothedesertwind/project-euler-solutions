/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.math.BigInteger;

/**
 *
 * @author aurix
 */
public class Problem0020 {

    private final static int ASCII_TO_ZERO = 48;

    public static void main(String[] args) {

        BigInteger a = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) {
            a = a.multiply(BigInteger.valueOf(i));
        }

        String value = a.toString();
        
        int result = 0;

        for (char c : value.toCharArray()) {
            result += (int) c - ASCII_TO_ZERO;
        }
        
        System.out.println(result);

    }
}
