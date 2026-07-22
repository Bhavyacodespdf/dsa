class Solution {
    public long subArrayRanges(int[] nums) {
        long max=submax(nums);
        long min=submin(nums);

        return max-min;
    }

    public long submin(int[] nums){
        int[] nse=NSE(nums);
        int[] pse=PSE(nums);

        long sum=0;

        for(int i=0;i<nums.length;i++){
            long left=i-pse[i];
            long right=nse[i]-i;

            long freq=left*right*1L;

            long val=freq*nums[i]*1L;

            sum=sum+val;
        }

        return sum;
    }

    public long submax(int[] nums){
        int[] nge=NGE(nums);
        int[] pge=PGE(nums);

        long sum=0;

        for(int i=0;i<nums.length;i++){
            long left=i-pge[i];
            long right=nge[i]-i;

            long freq=left*right*1L;

            long val=freq*nums[i]*1L;

            sum=sum+val;
        }

        return sum;
    }

    public int[] NSE(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }

            int nse=nums.length;
            if(!st.isEmpty()) nse=st.peek();
            res[i]=nse;

            st.push(i);
        }

        return res;
    }

    public int[] PSE(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            int pse=-1;
            if(!st.isEmpty()) pse=st.peek();
            res[i]=pse;

            st.push(i);
        }

        return res;
    }

    public int[] NGE(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }

            int nge=nums.length;
            if(!st.isEmpty()) nge=st.peek();
            res[i]=nge;

            st.push(i);
        }

        return res;
    }

    public int[] PGE(int[] nums){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }

            int pge=-1;
            if(!st.isEmpty()) pge=st.peek();
            res[i]=pge;

            st.push(i);
        }

        return res;
    }
}