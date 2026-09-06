class Solution {
    public int maxSubArray(int[] nums) {
        int best=nums[0];
        int maxs=nums[0];

        for(int i=1;i<nums.length;i++){
            best=Math.max(best+nums[i],nums[i]);
            maxs=Math.max(maxs,best);
        }

        return maxs;
    }
}