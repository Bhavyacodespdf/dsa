class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length<=2) return nums.length;
        else{
            int bitWidth = Long.SIZE - Long.numberOfLeadingZeros(nums.length);
            return 1<<bitWidth;
        }
    }
}