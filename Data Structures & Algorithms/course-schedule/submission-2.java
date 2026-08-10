class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) graph.add(new ArrayList<>());
        for(int [] p: prerequisites) graph.get(p[1]).add(p[0]);

        int [] visited = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(!dfs(i, graph, visited)) return false;
        }
        return true;

    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited){
        if(visited[node]== 1) return false;
        if(visited[node] == 2) return true;

        visited[node] = 1; // 开始访问
        // 如果递归访问当前node的所有邻接node发现有环即false
        for(int neighbor: graph.get(node)){
            if(!dfs(neighbor, graph, visited)){
                return false;
            }
        }
        visited[node] = 2; // 结束访问
        return true; 
    }
}
