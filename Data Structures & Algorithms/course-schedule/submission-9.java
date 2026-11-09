class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        // b -> a because b must be taken before a
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            if (graph[prerequisiteCourse] == null) {
                graph[prerequisiteCourse] = new ArrayList<>();
            }
            graph[prerequisiteCourse].add(course);
        }

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
        int course,
        List<Integer>[] graph,
        int[] state
    ) {
        if (graph[course] == null) {
            return true;
        }

        // Found a cycle
        if (state[course] == 1) {
            return false;
        }

        // Already processed successfully
        if (state[course] == 2) {
            return true;
        }

        // Mark as currently visiting
        state[course] = 1;

        for (int nextCourse : graph[course]) {
            if (!dfs(nextCourse, graph, state)) {
                return false;
            }
        }

        // Mark as fully processed
        state[course] = 2;
        return true;
    }
}
