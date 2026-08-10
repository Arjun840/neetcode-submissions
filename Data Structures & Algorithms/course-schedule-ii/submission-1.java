class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // We want to find if a valid ordering is possible, if it is
        // we return the order, if not return an empty array
        // We can do a DFS cycle detection, so keep traversing until we find
        // a course with no pre reqs, add that to the order, and then look
        // at the next course and see if we can add it
        // To detect a cycle, we'll keep some type of list of courses visited
        // if we ever return the the same course that's already been visited
        // then we know its a cycle, return empty
        // if we never reach a cycle we jsut keep addded courses to the ordering
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] prereq : prerequisites){
            preMap.putIfAbsent(prereq[0], new ArrayList<>());
            preMap.get(prereq[0]).add(prereq[1]);
        }
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i, preMap, cycle, visit, output)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            result[i] = output.get(i);
        }
        return result;

    }
    private boolean dfs(int course, Map<Integer, List<Integer>> preMap,
    Set<Integer> cycle, Set<Integer> visit, List<Integer> output){
        if (cycle.contains(course)){
            return false;
        }
        if (visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for (int prereq : preMap.getOrDefault(course, Collections.emptyList())){
            if (!dfs(prereq, preMap, cycle, visit, output)){
                return false;
            }
        }
        cycle.remove(course); // reset state
        visit.add(course); // courses prereqs can all be reached
        output.add(course); // add to order
        return true;
    }
}
