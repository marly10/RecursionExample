/*
Ricky McKenzie
Lab 8
*/
import java.io.*;
import java.util.*;

public class lab8_recursion {

   public static void main(String[] args) {
         
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer for Recursion & Iteration");
        int value = keyboard.nextInt();
        
      //Recursive & Iterative method call
        mysteryHelper(value);

        System.out.print("Enter the size of the array: ");
        int arraySize = keyboard.nextInt();

      //array & method being used to find the number of 0's in array list.
      int [] ZeroArr  = new int[arraySize];
      
      //for loop to store data 7 values in the value array declared at the top
      for (int i=0; i<arraySize; i++){
      
      //outputs the index of the array starting from 1. By using (i+1) to start at a positive int
      System.out.print("Value " + (i+1)+": ");

      //while loop(inside for loop) for validating user input. Only allows int and doubles. If string is inputed
      while (!keyboard.hasNextInt()) {        

       keyboard.next(); 
       System.out.println("\nI can only use Int values!");
       System.out.print("Value " + (i+1)+ ": "); 
       
                                  }//while loop ends

       //accepts the input of double and int
        ZeroArr[i] = keyboard.nextInt();

                        }//for loop ends



      System.out.println("\nThe number of 0's in an Array: " + ZeroCount(ZeroArr, 0));
   }

   //Method to call both mysteryRecursive & mysteryIterative methods at once! 
   public static void mysteryHelper(int n) {
      
      // n value used to compute both Recursive & Iterative methods
      System.out.println("Number: " + n);

      long startTimeIterative = System.currentTimeMillis(); //system milliseconds
      
      System.out.println("Iterative: " + mysteryIterative(n));//prints the Iterative method value
      
      //computes  milliseconds past after program ran
      long stopTimeIterative = System.currentTimeMillis();
      long elapsedTimeIterative = stopTimeIterative - startTimeIterative;
      //prints time gone by
      System.out.println("Iterative Time: " + elapsedTimeIterative+" MilliSec\n");

      long startTimeRecursive = System.currentTimeMillis(); //system milliseconds

      System.out.println("Recursive: " + mysteryRecursive(n));//prints the Recursive method value
      
      //computes  milliseconds past after program ran
      long stopTimeRecursive = System.currentTimeMillis();
      long elapsedTimeRecursive = stopTimeRecursive - startTimeRecursive;
      //prints time gone by      
      System.out.println("Recursive Time: " + elapsedTimeRecursive+" MilliSec");
      System.out.println();

   } //mysteryHelper method ends

   /*
   Write a main program that calls the following method with a 
   number of the user’s choice, and prints the result 
   (main and this method should be in same file).  
   */
   public static int mysteryRecursive(int n) {
      if (n <= 2) {
         return 1;
      } else {
         return mysteryRecursive(n - 1) + mysteryRecursive(n - 2);
      }
   } //mystery method ends


   public static int mysteryIterative(int n) {
      int count = 0;
      /*
      The Stack class represents a last-in-first-out (LIFO) stack of objects. 
      It extends class Vector with five operations that allow a vector to be treated as a stack. 
      */
      Stack < Integer > stackValue = new Stack < Integer > ();
      // "push():"Pushes an item onto the top of this stack
      stackValue.push(n);
      
      //Returns the number of components in this vecStackor
      while (stackValue.size() > 0) {
        /*
        "pop():" Removes the object at the top of this stack and 
        returns that object as the value of this function
        */
         int number = stackValue.pop();
         //base case used as "Exit parameter"
         if (number <= 2) {
            count += 1;
         } 
         //general case
         else {
        /*
        "push():"Pushes an item onto the top of this stack.
        */
            stackValue.push(number - 1);
            stackValue.push(number - 2);
         }
      }//while loop ends here
      return count;
   }

   public static int ZeroCount(int Arr[], int start) {
   
      //base case used as "Exit parameter"
      if (start >= Arr.length || start < 0) {
         return 0;
      }
      //general case
      int count = 0;
      if (Arr[start] == 0) {
         count += 1 ;
      }
      //recursive method call
      return ZeroCount(Arr, start + 1) + count;

   }

}

