class Solution {
    public int search(int[] nums, int target) {
        // Calculate starting middle value
        // have a left and right variable 
        // if middle value < target, we only look at upper half
        // if middle > target, we only look at lower half
        // keep iterating 
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int middle = l + ((r-l) / 2);
            if (nums[middle] < target){
                l = middle + 1;
            } else if (nums[middle] > target){
                r = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
