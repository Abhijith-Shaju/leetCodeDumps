class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(0, graph, path, result);
        
        return result;
    }

    private void dfs(int curr, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        if (curr == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[curr]) {
            path.add(neighbor);
            dfs(neighbor, graph, path, result);
            
            path.remove(path.size() - 1);
        }
    }
}