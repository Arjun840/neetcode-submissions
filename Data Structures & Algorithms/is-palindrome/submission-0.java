class Solution {
    public boolean isPalindrome(String s) {
        int right = s.length() - 1; // right pointer
        int left = 0; // left pointer
        while (left < right){
            while (left < right && !alphaNum(s.charAt(left))){ // Move left forward til it hits an alpha numeric
                left++;
            }
            while (right > left && !alphaNum(s.charAt(right))){ // Move right back til it hits alpha
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) // Compare the alpha nums
            != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++; right--; // Incremenet and check the loop again
        }
        return true; 
    }
    public boolean alphaNum(char c){
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
