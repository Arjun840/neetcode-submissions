class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        Stack<Character> aux = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (charMap.containsKey(curr)){
                if (!aux.isEmpty() && aux.peek() == charMap.get(curr)){
                    aux.pop();
                } else{
                    return false;
                }
            } else{
                aux.push(curr);
            }
        }
        return aux.isEmpty();
    }
}
