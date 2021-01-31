// https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D=greedy-algorithms
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.A
    static int luckBalance(int k, int[][] contests) {
        
        int luck = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        // loop through contests
        for(int i = 0; i < contests.length; ++i){
            
             // Increase luck with non-important competitions
            if(contests[i][1] == 0) 
                luck += contests[i][0];
                
            // Add to queue compeitions that have priority
            else if(contests[i][1] == 1) 
                queue.offer(contests[i][0]);
        }
    
        // Add to luck compeitions that have highest luck
        for(int i = 0; i < k; ++i){
            if(!queue.isEmpty())
                luck += queue.poll();
            else
                break;
        }
        
        // Win the rest of the compeitions, losing luck
        while(!queue.isEmpty()){
            luck -= queue.poll();
        } 
        
        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
