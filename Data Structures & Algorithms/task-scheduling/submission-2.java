class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Use a max heap that tracks frequency of task
        // Remove the top task, and decrement the frequency
        // Use queue to keep the order of the tasks
        // Queue has "task name, time left"
        // Then we do all the other possible tasks once
        // We check how much time has passed with some counter
        // If the time passed is >= n, then we can do the 
        // we'll convert the tasks to ascii keys
        int[] count = new int[26];
        for (char task : tasks){
            count[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count){
            if (cnt > 0){
                maxHeap.offer(cnt);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        // We need to see how much time has passed since last doing a task
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if (maxHeap.isEmpty()){
                time = q.peek()[1];
            } else{
                int task = maxHeap.poll() - 1;
                if (task > 0){
                q.offer(new int[] {task, time + n }); // track the time when its next available
            }
        }
        if (!q.isEmpty() && q.peek()[1] == time){
            maxHeap.offer(q.poll()[0]);
        }
     }
     return time;
    }
}


