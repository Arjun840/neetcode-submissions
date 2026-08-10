class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // We should keep a map that maps the courses to their prereqs
        // along with a hashset of the courses we visited so far
        // hashsst is for cycle detection, if we detect a cycle
        // that means its no longer posible, other than that, we continue
        // running a dfs through the prereqs list
        for (int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course){
        if (visiting.contains(course)){
            return false;
        }
        if (preMap.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);
        for (int pre : preMap.get(course)){
            if (!dfs(pre)){
                return false;
            }
        }
        visiting.remove(course); // reset state
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
