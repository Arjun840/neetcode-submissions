class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // We want to maintain a monotonic decreasing stack
        // We add the first value into the stack, check the next
        // value. If next value isn't greater add it to stack
        // If it is, pop value from stack, add new greater value,
        // and check the difference in indices
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index];
        for (int i = 0; i < temperatures.length; i++){
            int t = temperatures[i]; // current days temperature
            while (!stack.isEmpty() && t > stack.peek()[0]){ // while the
            // stack still has cooler days, and the temp is > than top of stack
                int[] pair = stack.pop(); // pop the cooler day
                res[pair[1]] = i - pair[1]; // At the index of the cooler day, add the differnece in indices
            }
            stack.push(new int[]{t, i}); // push new warmest day after stack is empty
        }
        return res;
    }
}
