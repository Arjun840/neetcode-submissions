class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> compMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            int curr = numbers[i];
            int comp = target - curr;
            if (compMap.containsKey(comp)){
                return new int[] {compMap.get(comp)+1, i+1};
            } 
            compMap.put(curr, i);
        }
        return new int[0];
    }
}
