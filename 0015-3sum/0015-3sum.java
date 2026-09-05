class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lis2=new ArrayList<>();
        Arrays.sort(nums);

        int i=0;
        while(i<nums.length){
            int l=i+1;
            int r=nums.length-1;

            while(l<r){
                if((nums[i]+nums[l]+nums[r])==0){
                    List<Integer> lis1=Arrays.asList(nums[i],nums[l],nums[r]);
                    lis2.add(lis1);
                    r--;
                    l++;
                    
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }

                else if((nums[i]+nums[l]+nums[r])<0) l++;
                else r--;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            i++;
        }

        return lis2;
    }
}