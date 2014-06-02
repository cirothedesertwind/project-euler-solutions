package solutions;

public class Problem0014Optimized {
    private static final long SIZE = 1000000;
    public static void main(String[] args){
        long startNumber = 0;
        long maxLinks = 0;
        long links;
        for (long i = SIZE-1; i > 0; i--){
            long k = i;
            links = 0;
            
            while (k > 1){
                links++;
                if (k % 2 == 0)
                    k = k / 2;
                else
                    k = 3*k + 1;
            }
            links++; //for 1.
            if (links > maxLinks){
                maxLinks = links;
                startNumber = i;
            }
        }
        System.out.println(startNumber);
    }
    
    //pr
}
