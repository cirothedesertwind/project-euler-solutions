package solutions;

import java.util.BitSet;
import util.LongVector;

public class Problem0023 {
    private static final int MAX = 28124;
    
    public static void main(String[] args) {
        LongVector v = new LongVector();
        
        for (long k = 12; k < MAX; k++){
            if (isAbundant(k)){
                v.addElement(k);
            }
        }
        
        BitSet b = new BitSet(MAX); //0 to 28123, set 0 to false to exclude
        b.set(0, MAX, true);
        b.set(0, false);
        
        //chose 2 distinct abundant numbers, then eliminate the result from the
        //bitset
        int idx;
        
        for (int i = 0; i < v.size(); i++)
            for (int j = i; j < v.size(); j++){
                idx = (int)(v.elementAt(i)+v.elementAt(j));
                
                //the sum only increases because the numbers are non-decreasing
                //so you don't have to do any work past this point
                if (idx > MAX)
                    break;
                
                b.set(idx, false);
            }
        
        System.out.println(sum(b));    
    }

    private static long sum(BitSet b) {
        long sum = 0;
        for (int i = 0; i < b.length(); i++)
            if (b.get(i))
                sum += i;
        
        return sum;
    }

    private static boolean isAbundant(long v) {
        int sum = 0;
        for (int i = 1; i < v; i++)
            if (v % i == 0)
                sum += i;
        
        return sum > v;
    }
}
