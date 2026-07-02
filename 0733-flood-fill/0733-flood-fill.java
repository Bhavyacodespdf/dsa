class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        if(oldcolor==color) return image;
        dfs(image,sr,sc,oldcolor,color);
        return image;
    }

    public void dfs(int[][] image,int r,int c, int oldcolor,int color){
        if(r>=image.length || c>=image[0].length ||  r<0 || c<0) return;
        if(image[r][c]!=oldcolor) return;
        image[r][c]=color;
        dfs(image,r+1,c,oldcolor,color);
        dfs(image,r,c+1,oldcolor,color);
        dfs(image,r-1,c,oldcolor,color);
        dfs(image,r,c-1,oldcolor,color);
    }
}