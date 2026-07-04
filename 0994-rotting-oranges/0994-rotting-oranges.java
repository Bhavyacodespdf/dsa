class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        int fresh=0;

        int[] x={-1,1,0,0};
        int[] y={0,0,1,-1};

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh>0){
            res++;
            int s=q.size();

            while(s!=0){
                int[] top=q.poll();
                int row=top[0];
                int col=top[1];
                for(int i=0;i<4;i++){
                    int r=row+x[i];
                    int c=col+y[i];

                    if(!(r>=n||c>=m||r<0||c<0)){
                        if(grid[r][c]==1){
                            q.offer(new int[]{r,c});
                            grid[r][c]=2;
                            fresh--;
                        }
                    }
                }
                s--;
            }
        }

        return (fresh>0) ? -1:res;
    }
}