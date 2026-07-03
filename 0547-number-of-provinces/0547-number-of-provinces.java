class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        int count=0;
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(isConnected,i,n,vis);
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected,int i,int n,boolean[] vis){
        vis[i]=true;

        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && vis[j]!=true){
                dfs(isConnected,j,n,vis);
            }
        }
    }
}