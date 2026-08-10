class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums {2, 1, 3, 4}
        // prefix {1, 0, 0, 0}
        // suffix {0, 0, 0, 1}
        // 
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1; 
        for (int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            // multiply prefix and suffix at every position
            res[i] = prefix[i] * suffix[i]; 
        }
        return res;
    }
}  
