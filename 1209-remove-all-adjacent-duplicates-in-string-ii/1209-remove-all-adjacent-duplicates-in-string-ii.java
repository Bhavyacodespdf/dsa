class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> st = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty()){
                st.push(new int[]{c,1});
                continue;
            }
            if(st.peek()[0]!=c){
                st.push(new int[]{c,1});
                continue;
            }
            if(st.peek()[1]<k){
                st.peek()[1]++;
                if (st.peek()[1] == k) {
                    st.pop();
                }
                continue;
            }
            st.pop();
        }

        StringBuilder sb= new StringBuilder();
        for(int[] item : st){
            for(int i=0;i<item[1];i++){
                sb.append((char) item[0]);
            }
        }

        return sb.reverse().toString();
    }
}