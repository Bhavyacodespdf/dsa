class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(candidates);
        int sum=0;

        helper(0,candidates,list,ans,sum,target);
        return list;
    }

    public void helper(int i,int[] candidates,List<List<Integer>> list,List<Integer> ans,int sum,int target){
        if(sum==target){
            list.add(new ArrayList<>(ans));
            return;
        }

        if(sum>target) return;

        for(int j=i;j< candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            ans.add(candidates[j]);
            sum+=candidates[j];
            helper(j+1,candidates,list,ans,sum,target);
            ans.removeLast();
            sum-=candidates[j];
        }
    }
}