// File: Stack.java
package org.gvp.dcs.ds;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack is full. Cannot push " + value + ".");
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (!isEmpty()) {
            int poppedValue = stackArray[top--];
            System.out.println("Popped " + poppedValue + " from the stack.");
            return poppedValue;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return a sentinel value to indicate an empty stack
        }
    }

    // Method to peek at the top element of the stack without removing it
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Top element of the stack: " + stackArray[top]);
           // return stackArray[top];
        } else {
            System.out.println("Stack is empty. No top element.");
            //return -1; // Return a sentinel value to indicate an empty stack
        }
    }
}
