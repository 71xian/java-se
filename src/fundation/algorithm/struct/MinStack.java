package fundation.algorithm.struct;

public class MinStack {

	private int[] stack;
	
	// 记录每部分数组的最小值
	private int[] mins;
	
	private int size;
	
	private int min;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new int[16];
    	mins = new int[16];
    }
    
    public void push(int x) {
    	if(size == stack.length) {
    		int[] grow = new int[size * 2];
    		System.arraycopy(stack, 0, grow, 0, size);
    		int[] growmin = new int[size * 2];
    		System.arraycopy(mins, 0, growmin, 0, size);
    		stack = grow;
    		mins = growmin;
    	}
    	if(size == 0) {
    		min = x;
    	}else {
    		if(x < mins[size - 1]) {
    			min = x;
    		}
    	}
    	stack[size] = x;
    	mins[size] = min;
    	size++;
    }
    
    public void pop() {
    	if(size == 0) {
    		return;
    	}
    	size--;
    	if(size != 0) {
    		min = mins[size - 1];    		
    	}
    }
    
    public int top() {
    	return stack[size - 1];
    }
    
    public int getMin() {
    	return mins[size - 1];
    }
    
}

