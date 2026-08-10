class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){ // new minimum
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        if (top == minStack.peek()){ // If the minimum is being popped, remove from minStack
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
