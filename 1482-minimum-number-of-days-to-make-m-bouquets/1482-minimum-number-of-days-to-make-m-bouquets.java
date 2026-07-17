class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=0;
        int high=Max(bloomDay);
        if(m*k>bloomDay.length) return -1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            int an=helper(bloomDay,mid,k);
            if(an>=m){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
    }

    public int helper(int[] bloomDay, int mid,int k){
        int c=0;
        int bc=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid) c++;
            else c=0;
            if(c==k){
                bc++;
                c=0;
            }
        }

        return bc;
    }

    public int Max(int[] bloomDay){
        int max=bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            if(max<bloomDay[i]) max=bloomDay[i];
        }

        return max;
    }
    
}