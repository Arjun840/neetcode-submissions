class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int mini = stack.peek();

        while (!stack.isEmpty()){
            mini = Math.min(mini, stack.peek());
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    return mini;
    }
}
