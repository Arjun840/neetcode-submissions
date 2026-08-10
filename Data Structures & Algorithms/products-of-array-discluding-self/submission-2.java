class Solution {
    public int[] productExceptSelf(int[] nums) {
        // {1, 1, 2, 8} Pre[i] is product of everyhting to left
        // {48,24,6,1} Post[i] is product of everyhting to right
        int[] pre = new int[nums.length];
        pre[0] = 1;
        int[] post = new int[nums.length];
        post[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++){
            pre[i] = nums[i-1] * pre[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--){
            post[i] = nums[i + 1] * post[i+1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}  
