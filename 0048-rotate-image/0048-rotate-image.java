class Solution {
    public void rotate(int[][] matrix) {
        int k=matrix.length;
        for(int i=0;i<k;i++){
            for(int j=i;j<k;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<k;i++){
            for(int j=0;j<k/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k-j-1];
                matrix[i][k-j-1]=temp;
            }
        }
    }
}