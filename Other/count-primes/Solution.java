// https://leetcode.com/problems/count-primes/

class Solution {
    public int countPrimes(int n) {
        
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        int count = 0;
        
        for(int i = 2; i < Math.sqrt(n); ++i){
            if(primes[i])
                count++;
            // remove Multiples of i  
            for(int j = 2; i*j <= n; j++){
                primes[i*j] = false;
            }
        }
        return count;
    }
}
