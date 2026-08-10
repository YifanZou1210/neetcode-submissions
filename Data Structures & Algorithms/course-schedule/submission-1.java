class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表 graph[i] 存储从课程 i 出发的所有依赖课程
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 填充邻接表
        for (int[] pair : prerequisites) {
            int course = pair[0];     // 要学的课程
            int prereq = pair[1];     // 前置课程
            graph.get(prereq).add(course); // prereq -> course
        }

        // 访问状态数组：0 = 未访问，1 = 访问中，2 = 访问完成
        int[] visited = new int[numCourses];

        // 对每门课程进行 DFS 检查
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false; // 如果检测到环
            }
        }

        return true; // 所有课程无环，可完成
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited) {
        // 如果当前节点是访问中，说明遇到了环
        if (visited[node] == 1) {
            return false;
        }

        // 如果当前节点已经访问完成，跳过
        if (visited[node] == 2) {
            return true;
        }

        // 标记当前节点为访问中
        visited[node] = 1;

        // 递归访问所有相邻课程
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited)) {
                return false;
            }
        }

        // 当前节点访问完成
        visited[node] = 2;
        return true;
    }
}
