class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (charMap.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == charMap.get(c)){
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
