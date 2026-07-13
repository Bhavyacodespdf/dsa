class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int maxc=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) c++;
            else{
                maxc=Math.max(maxc,c);
                c=0;
            }
        }

        return Math.max(maxc,c);
    }
}