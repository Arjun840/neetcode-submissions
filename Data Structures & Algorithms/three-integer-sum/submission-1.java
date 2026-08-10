class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Take each number in array as a first value
        // Use two pointer or hashmap approach to check the rest of the values
        // Array needs to be sorted
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){ // Choose each element in array as the single number
            if (i > 0 && nums[i-1] == nums[i]){ // If it's a duplicate skip it
                continue;
            }
            int left = i+1; // Initialize pointers in the loop. they need to be reset each time
            int right = nums.length - 1;
            while (left < right){ // Two pointer while loop
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the 3 sum
                if (sum > 0){ // too big
                    right--;
                } else if (sum < 0){ // too small
                    left++;
                } else{ // Equal to zero so add it it list of lists
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++; // increment
                right--; // decrement
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
            }   
        }
    }
    return res;
    }
}
