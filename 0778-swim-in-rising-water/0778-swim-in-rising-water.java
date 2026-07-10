class Solution {
    class Pair{
        int m;
        int r;
        int c;

        Pair(int m,int r,int c){
            this.m=m;
            this.r=r;
            this.c=c;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] res=new int[n][m];

        for(int i=0;i<n;i++){
            int[] ans=new int[m];
            Arrays.fill(ans,Integer.MAX_VALUE);
            res[i]=ans;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a, b) -> a.m-b.m
        );

        res[0][0]=grid[0][0];
        pq.offer(new Pair(grid[0][0],0,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int m1=top.m;
            int row=top.r;
            int col=top.c;

            if(m1>res[row][col]) continue;
            for(int k=0;k<4;k++){
                int r=row+dx[k];
                int c=col+dy[k];
                if(!(valid(r,c,n,m))) continue;
                int newmon=Math.max(m1,grid[r][c]);
                if(newmon<res[r][c]){
                    res[r][c]=newmon;
                    pq.offer(new Pair(newmon,r,c));
                }
            }
        }

        return res[n-1][m-1];
    }

    private boolean valid(int r,int c,int n,int m){
        if(r<0||c<0||r>=n||c>=m) return false;
        return true;
    }
}