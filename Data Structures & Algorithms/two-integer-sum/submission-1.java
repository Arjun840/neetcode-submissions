class Solution {
    public int[] twoSum(int[] nums, int target) {
        // We use a hashmap, mapping a compliment to index
        // We loop through nums, if map contains key target, 
        // then we return curr index plus index from map
        Map<Integer, Integer> complimentMap = new HashMap<>();
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
