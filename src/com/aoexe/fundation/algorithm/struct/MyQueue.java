package com.aoexe.fundation.algorithm.struct;

public class MyQueue {

	private int[] queue;
	
	private int first;
	
	private int last;
	
	 /** Initialize your data structure here. */
    public MyQueue() {
    	queue = new int[16];
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(last == queue.length) {
    		int[] newqueue = new int[last * 2];
    		System.arraycopy(queue, 0, newqueue, 0, last);
    		queue = newqueue;
    	}
    	queue[last] = x;
    	last++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	return queue[first++];
    }
    
    /** Get the front element. */
    public int peek() {
    	return queue[first];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return last == first;
    }
}
