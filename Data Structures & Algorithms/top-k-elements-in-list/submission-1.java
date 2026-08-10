class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            countMap.putIfAbsent(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
        for (int i = 0; i < k; i++){
            int frequent = 0;
            int maxCount = 0;
            for (int num : countMap.keySet()){
                if (countMap.get(num) > maxCount){
                    maxCount = countMap.get(num);
                    frequent = num;
                }
            }
            res[i] = frequent;
            countMap.remove(frequent);
        }
        return res;
    }
}
