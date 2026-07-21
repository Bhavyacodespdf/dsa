class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        
        for(int curr: asteroids){
            boolean alive=true;
            while(alive && curr <0 && !st.isEmpty() && st.peek()>0){
                if(st.peek()<Math.abs(curr)) st.pop();
                else if(st.peek()==Math.abs(curr)){
                    st.pop();
                    alive=false;
                }
                else alive=false;
            }

            if(alive) st.push(curr);
        }

        int[] res=new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i]=st.pop();
        }

        return res;

    }
}