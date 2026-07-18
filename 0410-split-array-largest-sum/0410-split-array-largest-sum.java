class Solution {
    public int splitArray(int[] nums, int k) {
        int low=max(nums);
        int high=sum(nums);
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(helper(nums,mid)<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
    }

    public int helper(int[] nums, int mid){
        int sum=0;
        int d=1;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>mid){
                d++;
                sum=nums[i];
            }
            else sum+=nums[i];
        }

        return d;
    }

    public int max(int[] nums){
        int m=nums[0];
        for(int i=1;i<nums.length;i++){
            if(m<nums[i]) m=nums[i];
        }

        return m;
    }

    public int sum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        return sum;
    }
}