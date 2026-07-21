class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();

        if(num.length()==k) return "0";

        for(char c: num.toCharArray()){
            int res = c - '0'; 

            while(!st.isEmpty() && st.peek()>res && k>0){
                k--;
                st.pop();
            }

            st.push(res);
        }

        if(k>0){
            while(k!=0 && !st.isEmpty()){
                st.pop();
                k--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++; 
        String result = sb.substring(i);
        return result.isEmpty() ? "0" : result;
    }
}