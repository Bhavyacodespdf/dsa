class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Max(nums);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(helper(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
    }

    public int helper(int[] nums, int m){
        int d=0;
        for(int i=0;i<nums.length;i++){
            d+=nums[i]/m;
            if(nums[i]%m!=0) d++;
        }
        return d;
    }

    public int Max(int[] nums){
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]) max=nums[i];
        }

        return max;
    }
}