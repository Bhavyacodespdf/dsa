class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word=s.split(" ");
        if(pattern.length()!=word.length) return false;

        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c1=pattern.charAt(i);

            if(map1.containsKey(c1) && !map1.get(c1).equals(word[i])) return false;
            if(map2.containsKey(word[i]) && !map2.get(word[i]).equals(c1)) return false;

            map1.put(c1,word[i]);
            map2.put(word[i],c1);
        }

        return true;
    }
}