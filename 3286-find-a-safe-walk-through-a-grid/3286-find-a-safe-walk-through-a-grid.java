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
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a, b) -> a.m-b.m
        );

        int[][] res=new int[n][m];

        for(int i=0;i<n;i++){
            int[] arr=new int[m];
            Arrays.fill(arr,Integer.MAX_VALUE);
            res[i]=arr;
        }

        // if(grid.get(0).get(0)==1) return false;
        pq.offer(new Pair(grid.get(0).get(0),0,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};


        res[0][0]=grid.get(0).get(0);
    
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int m1=top.m; 
            if(m1 >= health) continue;
            int r=top.r;
            int c=top.c;

            if(r==n-1 && c==m-1) return true;
            for(int k=0;k<4;k++){
                int row=r+dx[k];
                int col=c+dy[k];
                if(!(valid(row,col,n,m))) continue;
                int newCost=m1+grid.get(row).get(col);
                if(newCost<res[row][col]){
                    res[row][col]=newCost;
                    pq.offer(new Pair(newCost,row,col));
                }
            }
        }

        return false;
    }

    private boolean valid(int r,int c,int n,int m){
        if(r<0||c<0||r>=n||c>=m) return false;
        return true;
    }
}