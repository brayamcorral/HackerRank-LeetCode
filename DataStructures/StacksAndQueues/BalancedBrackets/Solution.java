// https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D=stacks-queues

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // isBalanced -- returns YES or No if a string is balanced
    // From hackerRank: Two brackets are considered to be a matched pair if the an opening bracket (i.e.,    // (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.        // There are three types of matched pairs of brackets: [], {}, and ().
    // Solution. Time: O(n), Space O(1)
    static String isBalanced(String s) {

        // String must be bigger then one bracket to be balanced
        if(s.length() < 1) return "NO";
        
        // Used to match the open and closed brackets
        HashMap<Character, Character> complementary = new HashMap<Character, Character>();
        complementary.put(']','[');
        complementary.put('}','{');
        complementary.put(')','(');
        
        // Used to identify open brackets
        HashMap<Character, Boolean> openBrackets = new HashMap<Character, Boolean>();
        openBrackets.put('{', true);
        openBrackets.put('(', true);
        openBrackets.put('[', true);
        
        // Start stack with first bracket
        Stack<Character> stack = new Stack();

        for(char currentChar : s.toCharArray()){
            
            // if stack is empty, insert open bracket and find its closing bracket.
            if(stack.empty()){
                // Can't add a closing bracket to an empty stack
                if(!(openBrackets.getOrDefault(currentChar, false))) return "NO";
                
                stack.push(currentChar);
                continue;
            }
            
            // Pop the open bracket if its "closing" bracket is found
            if(complementary.getOrDefault(currentChar, '\0') == stack.peek()){
                stack.pop();
            // If new open bracket is found, add it to the stack and find its closing bracket
            }else if(openBrackets.getOrDefault(currentChar, false)){
                stack.push(currentChar);
            // Comes here if a closing bracket is found but its not the correct one
            }else{
                return "NO";
            }
        }
        
        // If the stack is not empty, then an open bracket didnt have its corresponding closed bracket
        return (stack.empty()) ? "YES" : "NO";         
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
