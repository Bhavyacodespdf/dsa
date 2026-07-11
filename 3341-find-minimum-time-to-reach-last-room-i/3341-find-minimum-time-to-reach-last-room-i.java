class Solution {
    class Pair{
        int t;
        int r;
        int c;

        Pair(int t,int r,int c){
            this.t=t;
            this.r=r;
            this.c=c;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;

        int[][] res=new int[n][m];

        for(int i=0;i<n;i++){
            int[] ans=new int[m];
            Arrays.fill(ans,Integer.MAX_VALUE);
            res[i]=ans;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a, b) -> a.t-b.t
        );

        res[0][0]=0;
        pq.offer(new Pair(0,0,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int t=top.t;
            int row=top.r;
            int col=top.c;

            if(t>res[row][col]) continue;
            for(int k=0;k<4;k++){
                int r=row+dx[k];
                int c=col+dy[k];
                if(!(valid(r,c,n,m))) continue;
                int newtime=Math.max(t,moveTime[r][c])+1;
                if(newtime<res[r][c]){
                    res[r][c]=newtime;
                    pq.offer(new Pair(newtime,r,c));
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