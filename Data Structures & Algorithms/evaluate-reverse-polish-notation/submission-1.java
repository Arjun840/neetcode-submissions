class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (String str : tokens){
            if (str.equals("+")){
               int a = stack.pop();
               int b = stack.pop();
               stack.push(a+b);
            } else if (str.equals("-")){
               int a = stack.pop();
               int b = stack.pop();
               stack.push(b-a);
            } else if (str.equals("/")){
               int a = stack.pop();
               int b = stack.pop();
               stack.push(b/a);
            } else if (str.equals("*")){
               int a = stack.pop();
               int b = stack.pop();
               stack.push(a*b);
            } else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
