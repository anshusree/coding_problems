class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0,visited,rooms);
        for(boolean val:visited){
            if(!val) return false;
        }
        return true;
    }
    public void dfs(int source, boolean[] visited, List<List<Integer>> rooms){
        visited[source]=true;
        for(int neigh:rooms.get(source)){
            if(!visited[neigh]){
                dfs(neigh,visited,rooms);
            }
        }
    }
}
