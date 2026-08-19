class Solution {
    class Pair{
        int val;
        int freq;

        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> a.freq-b.freq
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }

        int[] arr=new int[k];

        for(int i=0;i<k;i++){
            arr[i]=pq.poll().val;
        }

        return arr;
    }
}