class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        if(oldcolor==color) return image;
        dfs(image,sr,sc,oldcolor,color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oldcolor,int color){
        if(sr>=image.length|| sr<0 || sc>=image[0].length|| sc<0) return;
        if(image[sr][sc]!=oldcolor) return;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,oldcolor,color);
        dfs(image,sr,sc+1,oldcolor,color);
        dfs(image,sr-1,sc,oldcolor,color);
        dfs(image,sr,sc-1,oldcolor,color);
    }
}