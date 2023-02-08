class Solution {
    public void dfs(int source, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[source] = 1;
        for(int neigh:adj.get(source)){
            if(visited[neigh]!=1){
                dfs(neigh,visited,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0; 
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected.length; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        for(int i=0; i<isConnected.length; i++){
            if(visited[i]!=1){
                dfs(i,visited,adjList);
                count++;
            }
        }
        return count;
    }
}
