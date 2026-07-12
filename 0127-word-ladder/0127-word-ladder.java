class Solution {
    class Pair{
        String w;
        int v;

        Pair(String w,int v){
            this.w=w;
            this.v=v;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i),map.getOrDefault(wordList.get(i),0)+1);
        }

        if(map.containsKey(beginWord)) map.put(beginWord,1);
        if(!(map.containsKey(endWord))) return 0;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        map.remove(beginWord);

        while(!q.isEmpty()){
            Pair top=q.poll();
            
            String w=top.w;
            int v=top.v;
            if(w.equals(endWord)) return v;
            char[] arr=w.toCharArray();
            for(int i=0;i<arr.length;i++){
                char c=arr[i];
                for(int j=97;j<=122;j++){
                    if(c==(char) j) continue;
                    arr[i]=(char)j;
                    String newWord = new String(arr);
                    if(map.containsKey(newWord)){
                        q.offer(new Pair(newWord,v+1));
                        map.remove(newWord);
                    }
                }
                arr[i]=c;
            }
        }

        return 0;
    }
}