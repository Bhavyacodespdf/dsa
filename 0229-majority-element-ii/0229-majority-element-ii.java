class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer> ans=new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int c=entry.getValue();
            if(c>(n/3)) ans.add(entry.getKey());
        }

        return ans;
    }
}