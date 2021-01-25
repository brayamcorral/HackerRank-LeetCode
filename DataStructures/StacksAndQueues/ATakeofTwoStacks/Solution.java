/* https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D%5B%5D=stacks-queues
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class MyQueue<E>{
    
        // s1 is used to take in elements
        Stack<E> s1 = new Stack();
        // s1 is moved to s2("queue")
        Stack<E> s2 = new Stack();
        
        private void moveS1toS2(){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        
        // enqueue -- adds elements to end of the queue, is not actually at the end
        // until s1 is moved to s2        
        public void enqueue(E val){
            s1.push(val);
        }
        
        // dequeue -- returns and removes element at the front of the queue
        // if s2 is empty, s1 will fill s2
        public E dequeue(){
            if(s2.empty()){
                moveS1toS2();
            }
            E front = s2.pop();
            return front; 
        }
        
        // peek -- returns element at the front of the queue
        // if s2 is empty, s1 will fill s2
        public E peek(){
            if(s2.empty()){
                moveS1toS2();
            }
            E front = s2.peek();
            return front; 
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
