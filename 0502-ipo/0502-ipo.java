class Solution {
    class Pair{
        int capital;
        int profit;

        Pair(int c,int p){
            capital=c;
            profit=p;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pq =new PriorityQueue<>(
            (a,b) -> a.capital-b.capital
        );

        for(int i=0;i<capital.length;i++){
            pq.add(new Pair(capital[i],profits[i]));
        }

        PriorityQueue<Integer> pq1 =new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<k;i++){
            while(!pq.isEmpty() && pq.peek().capital<=w){
                pq1.add(pq.peek().profit);
                pq.poll();
            }
            if(pq1.isEmpty()) return w;
            w+=pq1.poll();
        }


        return w;
    }
}