class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
    // Decision tree:
    // include [1] , [2] , [3]
    // include [1, 2] or [1, 3], [2, 1] or [2, 3], [3,1] or [3,2]
    // include [1, 2, 3] or [1, 3, 2] etc.
    if (nums.length == 0){
        return Arrays.asList(new ArrayList<>());
    }
    List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
    List<List<Integer>> res = new ArrayList<>();
    for (List<Integer> p : perms){
        for (int i = 0; i <= p.size(); i++){ // add available value in every possible position
            List<Integer> p_copy = new ArrayList<>(p);
            p_copy.add(i, nums[0]); 
            res.add(p_copy);
        }
    }
    return res;
    }
}
