class Solution {
    public int maxProfit(int[] prices) {
        int best=Integer.MAX_VALUE;
        int res=0;

        for(int i=0;i<prices.length;i++){
            best=Math.min(prices[i],best);
            res=Math.max(res,prices[i]-best);
        }

        return res;
    }
}