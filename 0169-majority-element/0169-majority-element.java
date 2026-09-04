class Solution {
    public int majorityElement(int[] nums) {
        int element=nums[0];
        int c=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==element) c++;
            else if(nums[i]!=element && c==0) element=nums[i];
            else c--;
        }

        return element;
    }
}