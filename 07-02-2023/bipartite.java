class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(color[i]==0 && dfs(i,1,color,graph)==false)
                return false;
        }
        return true;
    }
    public boolean dfs(int source, int currcol, int[] color, int[][] graph){
        color[source] = currcol;
        for(int neigh:graph[source]){
            if(color[neigh] == 0 && dfs(neigh,-currcol,color,graph)==false){
                    return false;
            }
            else if(currcol==color[neigh]) 
                return false;
        }
        return true;
    }
}
