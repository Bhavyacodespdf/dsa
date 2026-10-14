class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char l=st.pop();
                if((c==')' && l!='(') || (c=='}' && l!='{') || (c==']' && l!='[')) return false;
            }
        }

        if(!st.isEmpty()) return false;
        else return true; 
    }
}