class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Going through the array u can either choose to include the #
        // or choose to exclude the #. However, including the # doesn't disqualify
        // it from being used again. We can only have a certain amount of each value
        // to avoid getting duplicates.
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, 0, curr);
        return res;
    }

    public void backtrack(int[] nums, int target, int i, List<Integer> curr){
        if (target == 0){
            res.add(new ArrayList(curr));
            return;
        }
        if (target < 0 || i >= nums.length){
            return;
        }
        curr.add(nums[i]);
        backtrack(nums, target - nums[i], i, curr);
        curr.remove(curr.size() - 1);
        backtrack(nums, target, i + 1, curr);
    }
}
