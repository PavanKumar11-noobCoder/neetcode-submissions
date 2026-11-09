class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] courseGraph = new Set[numCourses + 1];
        for (int[] schedule : prerequisites) {
            if (courseGraph[schedule[0]] == null) {
                courseGraph[schedule[0]] = new HashSet<>();
            }
            courseGraph[schedule[0]].add(schedule[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (courseGraph[course] == null) {
                continue;
            }
            for (int preReq : courseGraph[course]) {
                if (!dfs(courseGraph, course, preReq, new boolean[numCourses])) {
                    return false;
                }
            }
            courseGraph[course] = null;
        }
        return true;
    }

    boolean dfs(Set<Integer>[] graph, int main, int preReq, boolean[] seen) {
        if (seen[preReq] || graph[preReq] == null) {
            return true;
        }
        if (graph[preReq].contains(main)) {
            return false;
        }
        seen[preReq] = true;
        for (int course : graph[preReq]) {
            if (!dfs(graph, main, course, seen)) {
                return false;
            }
        }
        return true;
    }
}
