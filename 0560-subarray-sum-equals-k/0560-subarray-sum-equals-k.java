class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=0;
        int prefsum=0;
        map.put(prefsum,map.getOrDefault(prefsum,0)+1);

        for(int i=0;i<nums.length;i++){
            prefsum+=nums[i];
            if(map.containsKey(prefsum-k)){
                c+=map.get(prefsum-k);
            }
            map.put(prefsum,map.getOrDefault(prefsum,0)+1);
        }
        
        return c;
    }
}