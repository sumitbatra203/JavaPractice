import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack    
       /*
            if(stackOldestOnTop.size()>0){
                while(!stackOldestOnTop.empty()){
                stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            stackNewestOnTop.push(value);        
            stackOldestOnTop= new Stack<T>();
            int stackSize=stackNewestOnTop.size();
            while(!stackNewestOnTop.empty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());            
            }
         */
         stackNewestOnTop.push(value);   
        }

        public T peek() {
       //     if(!stackOldestOnTop.empty())
       //     return stackOldestOnTop.peek();                        
       
           if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
            }
            if(!stackOldestOnTop.empty())
            return stackOldestOnTop.peek();    
        return null;
        }

        public T dequeue() {
            
            if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
            }
          //return stackOldestOnTop.pop();
            
            if(!stackOldestOnTop.empty())
            return stackOldestOnTop.pop();
            return null;
        
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
