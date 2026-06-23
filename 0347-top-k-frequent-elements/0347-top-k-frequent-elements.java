class Solution {
    class Pair{
        int first;
        int second;

        Pair(int f,int s){
            first=f;
            second=s;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> a.second-b.second
        );

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if (pq.size() > k) pq.poll(); 
        }

        int[] ans=new int[k];

        for(int i=0;i<k;i++){
            ans[i]=pq.peek().first;
            pq.poll();
        }

        return ans;
    }
}