class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums){
            numMap.putIfAbsent(num, 0);
            numMap.put(num, numMap.get(num) + 1);
        } // frequency map populated;
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }
        for (int key : numMap.keySet()){
            int freq = numMap.get(key);
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < k; i--){
           for (int val : bucket[i]){
                res[index] = val;
                index++;
                if (index == k){
                    return res;
                }
           }
        }
        return res;
    }
}
