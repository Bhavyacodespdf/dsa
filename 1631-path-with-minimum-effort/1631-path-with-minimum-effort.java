class Solution {
    class Pair{
        int d;
        int r;
        int c;

        Pair(int d,int r,int c){
            this.d=d;
            this.r=r;
            this.c=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][] res=new int[n][m];

        for(int i=0;i<n;i++){
            int[] arr=new int[m];
            Arrays.fill(arr,Integer.MAX_VALUE);
            res[i]=arr;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a, b)-> a.d-b.d
        );

        res[0][0]=0;
        pq.offer(new Pair(0,0,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int dis=top.d;
            int row=top.r;
            int col=top.c;

            if(dis>res[row][col]) continue;
            for(int k=0;k<4;k++){
                int r=row+dx[k];
                int c=col+dy[k];
                if(!(valid(r,c,n,m))) continue;
                int absum=Math.abs(heights[row][col]-heights[r][c]);
                int wt=Math.max(absum,dis);
                if(wt<res[r][c]){
                    res[r][c]=wt;
                    pq.offer(new Pair(wt,r,c));
                }
            }
        }

        return res[n-1][m-1];
    }

    public boolean valid(int r,int c,int n,int m){
        if(r<0||c<0||r>=n||c>=m) return false;
        return true;
    }
}