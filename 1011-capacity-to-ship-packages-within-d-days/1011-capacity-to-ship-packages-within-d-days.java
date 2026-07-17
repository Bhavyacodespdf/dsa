class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=max(weights);
        int high=sum(weights);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(helper(weights,mid)<=days){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
    }

    public int helper(int[] weights, int m){
        int d=0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>m){
                sum=weights[i];
                d++;
            }
            else sum+=weights[i];
            
        }
        d++;

        return d;
    }

    public int max(int[] weights){
        int max=weights[0];
        for(int i=1;i<weights.length;i++){
            if(max<weights[i]) max=weights[i];
        }

        return max;
    }

    public int sum(int[] weights){
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }

        return sum;
    }
}