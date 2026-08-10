class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, curr, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> curr, int i){
        if (target == 0){ // when combo adds to target
            res.add(new ArrayList(curr));
            return;
        }
        // when overshoot, or no new nums left to check
        if (target < 0 || i >= nums.length){
            return;
        }
        curr.add(nums[i]); // add i value
        backtrack(nums, target - nums[i], curr, i); // explore with duplicates of i
        curr.remove(curr.size() - 1); // backtrack
        backtrack(nums, target, curr, i + 1); // explore without adding i
    }
}
