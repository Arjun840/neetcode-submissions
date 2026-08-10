class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1]; // Since index 0 doesn't matter, we need it from 1-length+1
        
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for (int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1); // Put number and frequency in the map
        }
        for (int key : count.keySet()){
            freq[count.get(key)].add(key);
        }
        int res[] = new int[k]; // Extract k frequent
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--){
            for (int n : freq[i]){
                res[index] = n;
                index++;
                if (index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
