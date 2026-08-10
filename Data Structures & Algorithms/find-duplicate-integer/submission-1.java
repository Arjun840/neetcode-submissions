class Solution {
    public int findDuplicate(int[] nums) {
        // array contains n + 1 integers in the range frim (1, n)
        int fast = 0;
        int slow = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                break;
            }
        }
        int slow2 = 0;
        while (true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2){
                return slow;
            }
        }
    }
}
