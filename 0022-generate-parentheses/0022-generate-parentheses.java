class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        int open=0;
        int close=0;

        helper(0,0,n,sb,ans);
        return ans;
    }

    public void helper(int open,int close,int n,StringBuilder sb,ArrayList<String> ans){

        if(open==n && close==n){
            ans.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            helper(open+1,close,n,sb,ans);
            sb.deleteCharAt(sb.length() - 1); 
        }

        if(close<open){
            sb.append(')');
            helper(open,close+1,n,sb,ans);
            sb.deleteCharAt(sb.length() - 1); 
        }

    }
}