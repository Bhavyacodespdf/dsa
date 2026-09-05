class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int k=nums.length-1;
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int s1=Math.abs(nums[low]);
            int s2=Math.abs(nums[high]);
            if(s1>s2){
                ans[k]=nums[low]*nums[low];
                low++;
            }
            else{
                ans[k]=nums[high]*nums[high];
                high--;
            }

            k--;
        }

        return ans;
    }
}