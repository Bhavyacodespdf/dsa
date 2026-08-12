class Solution {
    public int jump(int[] nums) {
        int j=0;
        int farth=0;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            farth=Math.max(farth,i+nums[i]);
            if(i==end){
                j++;
                end=farth;
            }
        }
        return j;
    }
}