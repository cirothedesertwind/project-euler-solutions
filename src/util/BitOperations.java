package util;

public final class BitOperations {
    
    public static final void main(String[] args){
        System.out.println(countBitsSet(255));
    }
    
    
    /*http://graphics.stanford.edu/~seander/bithacks.html*/
    public static int countBitsSet(long v){
        // count the number of bits set in v
        int c;// c accumulates the total bits set in v
        for (c = 0; v > 0; c++){
            v &= v - 1; // clear the least significant bit set
        }
        
        return c;
    }
}
