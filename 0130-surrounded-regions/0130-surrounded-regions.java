class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,1,-1};

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int j=0;j<m;j++){
            if(board[0][j]=='O') dfs(board,0,j,n,m);
        }

        for(int j=0;j<m;j++){
            if(board[n-1][j]=='O') dfs(board,n-1,j,n,m);
        }

        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(board,i,0,n,m);
        }

        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O') dfs(board,i,m-1,n,m);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }
        
    }

    public boolean valid(int r,int c,int n,int m){
        if(r>=n || r<0 || c>=m || c<0) return false;
        return true;
    }

    public void dfs(char[][] board,int i,int j, int n,int m){
        board[i][j]='#';
        for(int k=0;k<4;k++){
            int r=i+dx[k];
            int c=j+dy[k];

            if(valid(r,c,n,m) && board[r][c]=='O') dfs(board,r,c,n,m);
        }
    }
}