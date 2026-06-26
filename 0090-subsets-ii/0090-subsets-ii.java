class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        helper(0,nums,list,ans);
        return list;
    }

    public void helper(int i,int[] nums,List<List<Integer>> list,List<Integer> ans){
        list.add(new ArrayList<>(ans));

        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            ans.add(nums[j]);
            helper(j+1,nums,list,ans);
            ans.removeLast();
        }
    }
}
