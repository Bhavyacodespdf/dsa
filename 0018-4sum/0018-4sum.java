class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();

        Arrays.sort(nums);
        int i=0;

        while(i<nums.length){
            int j=i+1;
            while(j<nums.length){
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    long sum=(long) nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;

                        while(l<r && nums[l]==nums[l-1]) l++;
                        while(l<r && nums[r]==nums[r+1]) r--;
                    }

                    
                    else if(sum<target) l++;
                    else r--;
                }
                while(j+1<nums.length && nums[j]==nums[j+1]) j++;
                j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            i++;
        }
        
        return ans;
    }
}