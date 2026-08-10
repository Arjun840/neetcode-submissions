class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // can utitlize a two pointer approach
        // since its sorted, left pointer starts at beginning, right pointer
        // at the end
        // check if it adds to target, if not move pointer
        // we'll move pointer based on if it's larger or smaller than target
        // if its smaller, move left pointer, if larger move right pointer
        int l = 0;
        int r = numbers.length - 1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if (sum < target){
                l++;
            } else if (sum > target){
                r--;
            } else{
                return new int[] {l + 1, r + 1};
            }
        }
        return new int[0];
    }
}
