class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // We'll be using a bucket sort
        // Use a map to track count per element in nums
        // Use an array of size nums + 1, with each index being the count,
        // so the highest index element is the highest count
        // each index will contain a list in case theres multiple with the same count
        // return k high indices in the array
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            numCount.putIfAbsent(nums[i], 0);
            numCount.put(nums[i], numCount.get(nums[i]) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<>();
        } 
        // Put each key in the correct index of the array which is the count
        for (int key : numCount.keySet()){
            bucket[numCount.get(key)].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--){
            for (int num : bucket[i]){
                result[index] = num;
                index++;
                if (index == k){
                    break;
                }
            }
        }
        return result;
    }
}
