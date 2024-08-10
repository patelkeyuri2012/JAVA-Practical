package org.gvp.dcs.ds;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor 
    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method to Insert an element into the queue
    public void enqueue(int value) {
        if (!isFull()) {
            if (rear == maxSize - 1) {
                rear = -1; // Wrap around if the rear reaches the end of the array
            }
            queueArray[++rear] = value;
            currentSize++;
            System.out.println("Enqueued " + value + " into the queue.");
        } else {
            System.out.println("Queue is full. Cannot enqueue " + value + ".");
        }
    }

    // Method to Deleted an element from the queue
    public int dequeue() {
        if (!isEmpty()) {
            int dequeuedValue = queueArray[front++];
            if (front == maxSize) {
                front = 0; // Wrap around if the front reaches the end of the array
            }
            currentSize--;
            System.out.println("Dequeued " + dequeuedValue + " from the queue.");
            return dequeuedValue;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a sentinel value to indicate an empty queue
        }
    }

    // Method to peek at the front element of the queue without removing it
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Front element of the queue: " + queueArray[front]);
           // return queueArray[front];
        } else {
            System.out.println("Queue is empty. No front element.");
            //return -1; // Return a sentinel value to indicate an empty queue
        }
    }
}