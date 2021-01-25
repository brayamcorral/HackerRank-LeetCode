/* https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D=stacks-queues
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class MyQueue<E>{
    
        Stack<E> s1 = new Stack();
        Stack<E> s2 = new Stack();
        
        private void moveS1toS2(){
            while(!s1.empty()){
                E temp = s1.pop();
                s2.push(temp);
            }
        }
        
        private void moveS2toS1(){
            while(!s2.empty()){
                E temp = s2.pop();
                s1.push(temp);
            }
        }
        
        public void enqueue(E val){
            s1.push(val);
        }
        
        public E dequeue(){
            if(!s1.empty() && s2.empty()){
                moveS1toS2();
                E front = s2.pop();
                moveS2toS1();
                return front; 
            }
            
            throw new IllegalArgumentException("Queue empty");
        }
        
        public E peek(){
            if(!s1.empty()){
                moveS1toS2();
                E front = s2.peek();
                moveS2toS1();
                return front; 
            }
            
            throw new IllegalArgumentException("Queue empty");
        }
  
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}


