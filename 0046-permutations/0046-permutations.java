class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        helper(0,nums,list,ans);
        return list;
    }

    public void helper(int i,int[] nums,List<List<Integer>> list,List<Integer> ans){
        if(ans.size()==nums.length){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int j=0;j<nums.length;j++){
            if(ans.contains(nums[j])) continue;
            ans.add(nums[j]);
            helper(i,nums,list,ans);
            ans.removeLast();
        }
    }
}