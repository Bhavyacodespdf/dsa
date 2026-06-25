class Solution {
    class Pair{
        int val;
        int row;
        int col;

        Pair(int v,int r,int c){
            val=v;
            row=r;
            col=c;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> b.val-a.val
        );

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(new Pair(matrix[i][j],i,j));
                if(pq.size()>k) pq.poll();
            }
        }

        return pq.peek().val;


    }
}