class Solution {
    class Pair{
        String word;
        int freq;

        Pair(String word,int freq){
            this.word=word;
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.freq!=b.freq) return a.freq-b.freq;
                return b.word.compareTo(a.word);
            }
        );
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }

        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll().word);
        }

        Collections.reverse(ans);
        
        return ans;

    }
}