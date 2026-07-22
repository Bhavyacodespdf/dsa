class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum=0;
        long mod = 1_000_000_007L;
        int[] nse=NSE(arr);
        int[] pse=PSE(arr);

        for(int i=0;i<arr.length;i++){
            long left=i-pse[i];
            long right=nse[i]-i;

            long freq = ((left % mod) * (right % mod)) % mod;
            
            long val  = (freq * (arr[i] % mod)) % mod;

            sum=(sum+val) % mod;
        }

        return (int)sum;
    }

    public int[] NSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            int nse=arr.length;
            if(!st.isEmpty()) nse=st.peek();
            res[i]=nse;

            st.push(i);
        }

        return res;
    }

    public int[] PSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];

        for(int i=0;i<arr.length;i++){

            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            int pse=-1;
            if(!st.isEmpty()) pse=st.peek();
            res[i]=pse;

            st.push(i);
        }

        return res;
    }
}