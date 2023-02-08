class Pair {
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count; 
    }
    public void bfs(int x, int y, int[][] visited, char[][] grid){
        visited[x][y]=1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,-1,1};
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}
