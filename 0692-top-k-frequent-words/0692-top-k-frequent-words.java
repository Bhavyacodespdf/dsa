class Solution {
    class Pair{
        int first;
        String second;

        Pair(int f,String s){
            first=f;
            second=s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();

        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first) return a.first-b.first;
                return b.second.compareTo(a.second);
            }
        );

        for(HashMap.Entry<String, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
            if(pq.size()>k) pq.poll();
        }

        ArrayList<String> arr=new ArrayList<>();

        for(int i=0;i<k;i++){
            arr.add(pq.peek().second);
            pq.poll();
        }

        Collections.reverse(arr);
        return arr;
    }
}