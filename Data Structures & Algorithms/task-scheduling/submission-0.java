class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Take the count of each task (letter) using a data structure
        // Create a max heap and insert the counts into the heap
        // We want to start completing the most repeated tasks first
        // Pop it from heap, add count of task to a queue along with the next
        // time the task can be completed
        // Continue doing this for the top tasks and add the tasks back from the queue
        // into the heap when the idle time is up.
        int[] letters = new int[26];
        for (char task : tasks){
            int index = task - 'A';
            letters[index]++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++){
            if (letters[i] != 0){
                maxHeap.add(letters[i]);
            }
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if (maxHeap.isEmpty()){
                time = q.peek()[1];
            } else{
                int curr = maxHeap.poll() - 1;
                if (curr > 0){
                    q.add(new int[]{curr, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
