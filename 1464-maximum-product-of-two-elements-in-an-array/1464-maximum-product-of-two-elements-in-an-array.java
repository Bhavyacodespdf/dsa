class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int smax=nums[1];

        for(int i=1;i<nums.length;i++){
            if(nums[i]>=max){
                smax=max;
                max=nums[i];
            }
            else if(nums[i]<max && nums[i]>=smax) smax=nums[i];
        }

        return (max-1)*(smax-1);
    }
}