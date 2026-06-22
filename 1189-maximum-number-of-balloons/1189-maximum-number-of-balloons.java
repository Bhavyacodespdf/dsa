class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char c: text.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int res=Integer.MAX_VALUE;
        res=Math.min(res,map.getOrDefault('b',0)/1);
        res=Math.min(res,map.getOrDefault('a',0)/1);
        res=Math.min(res,map.getOrDefault('l',0)/2);
        res=Math.min(res,map.getOrDefault('o',0)/2);
        res=Math.min(res,map.getOrDefault('n',0)/1);
        return res;

    }
}