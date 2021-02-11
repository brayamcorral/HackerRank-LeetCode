// https://leetcode.com/problems/perfect-squares/
class Solution {

     public int numSquares(int n) {

        int[] arr = new int[n+1]; 
        Arrays.fill(arr, Integer.MAX_VALUE);
        return helper(n, arr);
    }

    public int helper(int n, int[] arr){

        // base cases
        if(n <= 3) 
            return n;
        if(arr[n] != Integer.MAX_VALUE) 
            return arr[n];

        int square = (int)Math.sqrt(n);
        int min = n;

        for(int i = square; i > 0; --i){
            min = Math.min(min, helper((n - i*i), arr) + 1);
        }

        arr[n] = min;
        return min;

    }   
}
