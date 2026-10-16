class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<StringBuilder> st2=new Stack<>();

        int num=0;
        StringBuilder sb=new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) num = num * 10 + (c - '0');
            else if(c=='['){
                st1.push(num);
                num=0;
                st2.push(sb);
                sb=new StringBuilder();
            }
            else if(c==']'){
                int key=st1.pop();
                StringBuilder value=st2.pop();

                for(int i=0;i<key;i++){
                    value.append(sb);
                }

                sb=value;
            }
            else {
                sb.append(c);
            }
            
        }
        return sb.toString();
    }

}