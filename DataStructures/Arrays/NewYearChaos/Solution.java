// https://www.hackerrank.com/challenges/new-year-chaos/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        
        int[] flipped = new int[q.length +1];
        int flips = 0;
        Arrays.fill(flipped, 0);
        
        // Bubble sort
        for(int i = 0; i < q.length-1; ++i){
            for(int j = i+1; j < q.length; ++j){
                if(q[i] > q[j]){
                    if(flipped[q[i]] >= 2){
                        System.out.println("Too chaotic");
                        return;
                    }
                    flipped[q[i]]++;
                    flips++;
                    int temp = q[i];
                    q[i] = q[j];
                    q[j] = temp;
                }   
            }
        }
        System.out.println(flips);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
