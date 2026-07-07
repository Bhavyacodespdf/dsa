class Solution {
    boolean res=true;
    public boolean isBipartite(int[][] graph) {
        int[] c = new int[graph.length];
        Arrays.fill(c, -1);
        for(int i=0;i<graph.length;i++){
            if(c[i]==-1) dfs(graph,i,0,c);
        }
        return res;
    }

    public void dfs(int[][] graph,int i, int col,int[]c){
        c[i]=col;
        for(int j=0;j<graph[i].length;j++){
            int n=graph[i][j];
            if(c[n]!=-1 && c[n]==col) res=false;
            if(c[n]==-1) dfs(graph,n,1-col,c);
        }
    }
}