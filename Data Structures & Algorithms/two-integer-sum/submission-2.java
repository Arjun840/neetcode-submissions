class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        // map number to it's index
        for (int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if (complimentMap.containsKey(compliment)){
                return new int[] {complimentMap.get(compliment), i};
            }
            complimentMap.put(nums[i], i);
        }
          return new int[0];
    }
}
