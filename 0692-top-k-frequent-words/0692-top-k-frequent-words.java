class Solution {
    class Pair{
        String s;
        int freq;

        Pair(String s,int freq){
            this.s=s;
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();

        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) ->{
                if(a.freq!=b.freq) return a.freq-b.freq;
                else return b.s.compareTo(a.s);
            }
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }

        List<String> ls=new ArrayList<>();

        for(int i=0;i<k;i++){
            ls.add(pq.poll().s);
        }

        Collections.reverse(ls);
        return ls;

    }
}