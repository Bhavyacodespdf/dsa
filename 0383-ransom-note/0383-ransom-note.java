class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        for(char c: map1.keySet()){
            if(map1.get(c) > map2.getOrDefault(c,0)) return false;
        }


        return true;
    }
}