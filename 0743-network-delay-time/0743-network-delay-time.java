class Solution {
    class Pair{
        int d;
        int n;

        Pair(int d,int n){
            this.d=d;
            this.n=n;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> ans=new ArrayList<>();

        for(int i=0;i<=n;i++){
            ans.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            ans.get(u).add(new Pair(w,v));
        }

        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a, b) -> a.d-b.d
        );

        dis[k]=0;
        pq.offer(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int d1=top.d;
            int n1=top.n;
            if(d1>dis[n1]) continue;
            for(int i=0;i<ans.get(n1).size();i++){
                int n2=ans.get(n1).get(i).n;
                int wt=ans.get(n1).get(i).d;
                if(d1+wt<dis[n2]){
                    dis[n2]=d1+wt;
                    pq.offer(new Pair(d1+wt,n2));
                }

            }
        }

        int max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dis[i]);
        }
        
        return (max!=Integer.MAX_VALUE) ? max:-1;

        
    }
}