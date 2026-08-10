class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if (numMap.containsKey(compliment)){
                return new int[] {numMap.get(compliment), i};
            } 
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}

// index 0, 3, compliment is 4 if hashmap contains 4, then return 0, 1
// index 1, 4, compliment is 3 if hashmap contains 3,
