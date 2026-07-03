class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int time=0;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int s=q.size();

            while(s!=0){
                int[] top=q.poll();
                int r=top[0];
                int c=top[1];
                for(int k=0;k<4;k++){
                    int row=r+dx[k];
                    int col=c+dy[k];

                    if(!(row>=n || col>=m || row<0 || col<0)){
                        if(grid[row][col]==1){
                            q.offer(new int[]{row,col});
                            grid[row][col]=-2;
                            fresh--;
                        }
                    }
                }
                s--;
            }
        }

        return (fresh>0) ? -1 : time;
    }
}