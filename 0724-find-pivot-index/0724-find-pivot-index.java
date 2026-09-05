class Solution {
    public int pivotIndex(int[] nums) {
        int pref=0;
        int sum=0;
        int suff=0;

        for(int n:nums){
            sum+=n;
        }

        for(int i=0;i<nums.length;i++){
            suff=sum-pref-nums[i];
            if(pref==suff) return i;
            pref+=nums[i];
        }

        return -1;
    }
}