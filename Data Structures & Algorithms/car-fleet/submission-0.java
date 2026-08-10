class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0])); // sort by position
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair){
            stack.push((double) (target - p[0]) / p[1]); // compute time to 
            // reach destination for each car using target - position / speed
            if (stack.size() >= 2 && stack.peek() // while there are two cars in stack 
            <= stack.get(stack.size() - 2)){ // if curr car is faster or equal to car before it
            // form a fleet by popping it (only need to track head car) 
                stack.pop();
            }
        }
        return stack.size();
    }
}
