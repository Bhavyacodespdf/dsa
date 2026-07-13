class Solution {
    public boolean check(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int c=0;
        if(nums[left]<nums[right]) c++;
        while(left<right){
            if(nums[left]>nums[left+1]) c++;
            left++;
        }

        return (c<=1) ? true : false;

    }
}