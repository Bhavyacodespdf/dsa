class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int res=0;
        boolean hasOdd =false;

        for(char c:map.keySet()){
            res=res+((map.get(c)/2)*2);
            if(map.get(c) % 2 == 1) hasOdd=true;
        }

        return (hasOdd) ? res+1 :  res;
    }
}