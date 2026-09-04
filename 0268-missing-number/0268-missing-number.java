class Solution {
    public int missingNumber(int[] nums) {
        int s1=0;
        int s2=0;

        for(int i=1;i<=nums.length;i++){
            s1+=i;
            s2+=nums[i-1];
        }

        return s1-s2;

    }
}