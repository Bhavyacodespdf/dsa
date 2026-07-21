class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int s;

    public MinStack() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int value) {
        st1.push(value);
        if(st2.isEmpty()) st2.push(value);
        else{
            if(value<st2.peek()) st2.push(value);
            else st2.push(st2.peek());
        }
    }
    
    public void pop() {
        st1.pop();
        st2.pop(); 
    }
    
    public int top() {
       return st1.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */