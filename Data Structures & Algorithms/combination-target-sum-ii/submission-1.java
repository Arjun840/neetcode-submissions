class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Similar logic to combination sum but this time we want to avoid
        // duplicates so we can sort the input and skip until we find a non-duplicate
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, curr);
        return res;

    }

    public void backtrack(int[] candidates, int target, int i, List<Integer> curr){
        if (target == 0){
            res.add(new ArrayList(curr));
            return;
        }
        if (target < 0 || i >= candidates.length){
            return;
        }
        curr.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i + 1, curr);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        backtrack(candidates, target, i + 1, curr);
    }
}
