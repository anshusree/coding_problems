class Pair{
    int first;
    int second;
    int third;
    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third; 
    } 
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
            }
        }
        int t = 0;
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,-1,1};
        while(!queue.isEmpty()){
            int row = queue.peek().first;    
            int col = queue.peek().second;
            int time = queue.peek().third;
            t = Math.max(time,t);
            queue.poll();
            // Pair curr = queue.poll();
            // int row = curr.first;
            // int col = curr.second;
            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=2;
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t;
    }
}
