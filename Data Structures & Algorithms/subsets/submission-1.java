class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i){
        if (i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]); // include
        dfs(nums, i + 1);
        subset.remove(subset.size() - 1); // exclude
        dfs(nums, i + 1);
    }
}
