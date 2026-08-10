class Solution {
    public int longestConsecutive(int[] nums) {
        // We'll use a set to get rid of duplicates
        // Then we'll go loop through the set
        // start the count at 1,
        // then use a while loop until there isnt a consecutive sequence anymore
        // then set the largest variable to the count if its the new largest

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums){
            if (!numSet.contains(num - 1)){ // this means it will be the start
                int largest = 1;
                while (numSet.contains(num + largest)){
                largest++;
            }
            longest = Math.max(largest, longest);
            }
        }
        return longest;
    }
}
