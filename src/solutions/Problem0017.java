/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

/**
 *
 * @author aurix
 */
public class Problem0017 {

    final static String[] ONES = {"zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"};
    final static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    final static String[] TENS = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"};
    final static String HUNDRED = "hundred";
    final static String THOUSAND = "thousand";

    public static void main(String[] args) {
        int[] onesLen = new int[ONES.length];
        int[] teensLen = new int[TEENS.length];
        int[] tensLen = new int[TENS.length];

        for (int i = 0; i < 10; i++) {
            onesLen[i] = ONES[i].length();
            teensLen[i] = TEENS[i].length();
            tensLen[i] = TENS[i].length();
        }

        int thousandLen = THOUSAND.length();
        int hundredLen = HUNDRED.length();

        long n = 0;
        int c;

        for (int i = 1; i <= 1000; i++) {
            int v = i;
            c = 0;

            //System.out.print(i + ": ");

            if (v / 1000 > 0) {
                c += thousandLen;
                c += onesLen[1];
                v -= 1000;
                //System.out.println("onethousand");
            }

            if (v / 100 > 0) {
                c += hundredLen;
                c += onesLen[v / 100];
                //System.out.print(ONES[v / 100] + "hundred");
                v -= (v / 100) * 100; //integer math

            }

            if (v / 10 > 1) {
                c += tensLen[v / 10];
                //System.out.print(TENS[v / 10]);
                v -= (v / 10) * 10; //integer math

            } else if (v / 10 > 0) {
                c += teensLen[v - 10];
                //System.out.print(TEENS[v - 10]);
                v -= v;

            }

            if (v > 0) {
                c += onesLen[v];
                ///System.out.print(ONES[v]);
                v -= v;
            }

            //AND.
            //Just to make life more difficult.
            if (i > 99 && i % 100 != 0) {
                c += 3;
            }

            n += c;

            //System.out.println(" - " + c);
        }

        System.out.println(n);
    }
}
