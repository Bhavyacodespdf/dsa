class Solution {
    public int minMoves(int[] nums) {
        int count=0;
        int m=max(nums);

        for(int i=0;i<nums.length;i++){
            count=count+(m-nums[i]);
        }

        return count;
    }

    private int max(int[] nums){
        int m=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>m) m=nums[i];
        }

        return m;
    }
}