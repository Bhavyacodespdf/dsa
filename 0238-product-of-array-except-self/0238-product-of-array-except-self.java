class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] p=new int[nums.length];
        int suff=1;
        p[0]=1;

        for(int i=1;i<nums.length;i++){
            p[i]=p[i-1]*nums[i-1];
        }

        for(int i=nums.length-1;i>=0;i--){
            p[i]=p[i]*suff;
            suff=suff*nums[i];
        }

        return p;

    }
}