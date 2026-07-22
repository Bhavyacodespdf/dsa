class Solution {
    public int trap(int[] height) {
        int lmax=0;
        int rmax=0;
        int l=0;
        int r=height.length-1;
        int total=0;

        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=lmax) lmax=height[l];
                else total+=lmax-height[l];
                l++;
            }
            else{
                if(height[r]>=rmax) rmax=height[r];
                else total+=rmax-height[r];
                r--;
            }

        }

        return total;
    }
}