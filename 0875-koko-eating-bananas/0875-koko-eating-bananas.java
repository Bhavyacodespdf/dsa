class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Max(piles);

        int ans=0;

        while(low<=high){
            int m=(low+high)/2;
            long help=helper(piles,m);

            if(help<=h){
                ans=m;
                high=m-1;
            }
            else low=m+1;
        }

        return ans;
    }

    private long helper(int[] piles,int m){
        long sum=0;

        for(int i=0;i<piles.length;i++){
            sum+=piles[i]/m;
            if(piles[i]%m!=0) sum++;
        }

        return sum;
    }

    private int Max(int[] piles){
        int m=piles[0];

        for(int i=1;i<piles.length;i++){
            if(m<piles[i]) m=piles[i];
        }

        return m;
    }
}