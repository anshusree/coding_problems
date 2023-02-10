class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int incolor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] visited = image;
        dfs(image,sr,sc,visited,incolor,color);
        return visited;
    }
    public void dfs(int[][] image, int row, int col, int[][] visited, int incolor, int color){
        visited[row][col] = color;
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && ncol>=0 && nrow<image.length && ncol<image[0].length && 
                visited[nrow][ncol]!=color && image[nrow][ncol]==incolor){
                    dfs(image,nrow,ncol,visited,incolor,color);
            }
        }
    }
}


//class Solution {
//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int incolor = image[sr][sc];
//        if(incolor==color)
//            return image;
//        int row = image.length;
//        int col = image[0].length;
//        dfs(image,sr,sc,incolor,color);
//        return image;
//    }
//    public void dfs(int[][] image, int row,int col,int incolor, int color){
//        if(row<0 || col<0 || row>=image.length || col>=image[0].length || image[row][col]!=incolor)
//        return;        
//     image[row][col]=color;
//     dfs(image,row,col-1,incolor,color);
//     dfs(image,row,col+1,incolor,color);
//     dfs(image,row-1,col,incolor,color);
//     dfs(image,row+1,col,incolor,color);
        
        
    }
}
