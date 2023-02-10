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
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[][] res = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,-1,1};
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            int dist = queue.peek().third;
            queue.poll();
            res[row][col]=dist;
            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0){
                    queue.add(new Pair(nrow,ncol,dist+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        return res;
    }
}
