/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

/**
 *
 * @author Aurix
 */
public class Problem0018and0067 {
    
    //The triagle, represented as a binary tree stored in an array
    private static final int[] TRIANGLE_18 = new int[]{75,95,64,17,47,82,18,35,
        87,10,20,4,82,47,65,19,1,23,75,3,34,88,2,77,73,7,63,67,99,65,4,28,
        6,16,70,92,41,41,26,56,83,40,80,70,33,41,48,72,33,47,32,37,16,94,29,53,
        71,44,65,25,43,91,52,97,51,14,70,11,33,28,77,73,17,78,39,68,17,57,91,71,
        52,38,17,14,91,43,58,50,27,29,48,63,66,4,68,89,53,67,30,73,16,69,87,40,
        31,4,62,98,27,23,9,70,98,73,93,38,53,60,4,23};
    
    
    public static void main(String[] args){
        System.out.println(maxTriangleSum(TRIANGLE_18,0));
        //System.out.println(triangleSum(TRIANGLE_67,0));
        
        //System.out.println(maxTriangleSum(TRIANGLE_18));
    }
    
    //Top Down Solution (It overflows the stack)
    private static long maxTriangleSum(int[] tree, int index){
        if (index >= tree.length)
            return 0;
        
        long value = tree[index];
        int leftIndex = triangleTraverseLeft(index);
        return value + Math.max(maxTriangleSum(tree,leftIndex),
                                maxTriangleSum(tree,leftIndex+1));//L + 1 = R
    }

    private static int triangleTraverseLeft(int n){
        return (int)Math.ceil(((Math.sqrt(9+8*n)-3) /2.0D)+1);
    }
}