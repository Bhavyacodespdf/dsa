class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int c=0;

        while(sb.length()<b.length()){
            sb.append(a);
            c++;
        }
        
        if(sb.toString().contains(b)) return c;

        sb.append(a);
        c++;

        if(sb.toString().contains(b)) return c;

        return -1;

    }
}