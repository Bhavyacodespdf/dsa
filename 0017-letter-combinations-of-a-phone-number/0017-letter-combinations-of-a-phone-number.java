class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans=new  ArrayList<>();
        StringBuilder sb=new StringBuilder();
        if(digits.length()==0) return ans;
        
        String[] map = {
            "",     
            "",     
            "abc",  
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv", 
            "wxyz"
        };


        helper(0,digits,map,sb,ans);
        return ans;
    }

    public void helper(int i,String digits,String[] map,StringBuilder sb,ArrayList<String> ans){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }

        int digit=digits.charAt(i)-'0';
        String letter=map[digit];

        for(char c:letter.toCharArray()){
            sb.append(c);
            helper(i+1,digits,map,sb,ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}