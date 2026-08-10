class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            maxHeap.offer(stone);
        }
        while (!maxHeap.isEmpty()){
            if (maxHeap.size() == 1 ){
                return maxHeap.peek();
            }
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int newStone = 0;
            if (stone1 > stone2){
                newStone = stone1 - stone2;
            }
            maxHeap.offer(newStone);
        }
        return 0;
    }
}
