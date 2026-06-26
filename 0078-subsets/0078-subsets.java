class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        helper(0,nums,list,ans);
        return list;
    }

    public void helper(int i,int[] nums,List<List<Integer>> list,List<Integer> ans){
        list.add(new ArrayList<>(ans));

        for(int j=i;j<nums.length;j++){
            ans.add(nums[j]);
            helper(j+1,nums,list,ans);
            ans.removeLast();
        }
    }
}