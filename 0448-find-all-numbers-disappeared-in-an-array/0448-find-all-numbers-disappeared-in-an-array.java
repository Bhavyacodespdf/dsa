class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] pres=new int[nums.length+1];
        List<Integer> ans=new ArrayList<>();
        for(int i:nums){
            pres[i]=1;
        }
        for(int i=1;i<=nums.length;i++){
            if(pres[i]==0) ans.add(i);
        }

        return ans;
    }
}