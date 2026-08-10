class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        for (char c : s.toCharArray()){
            if (charMap.containsKey(c)){
                if (!stack.isEmpty() && charMap.get(c) == stack.peek()){
                    stack.pop();
                } else{
                    return false;
                }
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
