// https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings&isFullScreen=true
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Time: O(n^2), Space: O(1)
public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        long special = 0;
 
        for(int i = 0; i < n; ++i){
            
            long leftCount = 0;
            long rightCount = 0;
            boolean sequence = true;
            char current = s.charAt(i);
            
            for(int j = i+1; j < n; ++j){
                char next = s.charAt(j);
                
                // Checks if repeating letters
                if(current == next && sequence){
                    special++;
                    leftCount++;
                // Found a letter that isnt repeating
                }else if(current != next && sequence){
                    sequence = false;
                // Checks if same amount of chars on left and right of middle
                }else if(current == next && !sequence){
                    if(leftCount == rightCount){
                        special++;
                        break;
                    }
                    rightCount++;
                // Right chars dont match left chars
                }else if(current != next && !sequence){
                    break;
                }   
            }
        }

        return special + n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
