class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array first to get ascending order
        // then we'll loop through array once using each element
        // as the "first" element, then use two pointers to check 
        // rest of the elements to see if they add to 0 with the first
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break; 
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue; // duplicate we can skip
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0){
                    l++;
                } else if (sum > 0){
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // found one solution
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
