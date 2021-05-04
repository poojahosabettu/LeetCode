class Solution {
    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};
    public void solve(char[][] board) {
        
        for(int i = 0;i<board.length;++i){
            for(int j = 0;j<board[0].length;++j){
                if((i == 0||j == 0 || i == board.length-1||j == board[0].length-1) && board[i][j] == 'O'){
                    dfs(board,i,j,'*');
                }
            }
        }
        
         for(int i = 0;i<board.length;++i){
             for(int j = 0;j<board[0].length;++j){
                 if(board[i][j] == 'O')
                     board[i][j] = 'X';
                 if(board[i][j] == '*')
                     board[i][j] = 'O';
             }
         }
    }
    
    
    public void dfs(char[][] board, int I, int J, char c){
        if(I<0||J<0||I>=board.length||J>=board[0].length || board[I][J] == 'X' || board[I][J] == c)
            return;
        else{
            board[I][J] = c;
            for(int i = 0;i<4;++i){
                dfs(board,I+dr[i],J+dc[i],c);
            }
        }
    }
}