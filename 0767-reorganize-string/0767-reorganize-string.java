class Solution {
    class Pair{
            int freq;
            char character;

            Pair(int f,char c){
                freq=f;
                character=c;
            }
        }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> b.freq-a.freq
        );

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey()));
        }

        StringBuilder str=new StringBuilder();
        int seat=0;

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            if(seat==0 || str.charAt(seat-1)!=top.character){
                str.append(top.character);
                seat++;
                if(top.freq-1>0) pq.add(new Pair(top.freq-1,top.character));

            }

            else{
                if(pq.isEmpty()) return "";
                Pair top1=pq.poll();
                str.append(top1.character);
                seat++;
                if(top1.freq-1>0) pq.add(new Pair(top1.freq-1,top1.character));
                pq.add(top);
            }
        }

        return str.toString();

    }
}