class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        int res=0;
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && vis[i]!=true){
                    res++;
                    dfs(isConnected,i,m,vis);
                }
            }
        }
        return res;
    }


    public void dfs(int[][] isConnected,int i,int m,boolean[] vis){
        vis[i]=true;

        for(int j=0;j<m;j++){
            if(isConnected[i][j]==1 && vis[j]!=true){
                dfs(isConnected,j,m,vis);
            }
        }
    }
}