class Solution {
    public int removeDuplicates(int[] nums) {
        int low=0;
        for(int i=0;i<nums.length;i++){
            while(nums[low]!=nums[i]) nums[++low]=nums[i];
        }

        return low+1;
    }
}