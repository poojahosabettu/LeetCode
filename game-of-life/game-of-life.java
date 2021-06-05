class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                int live = count(board,i,j);
                if(board[i][j] == 0)
                    board[i][j] = live == 3?2:0; //2 represents live cell without disturning existing live cell
                else{
                    board[i][j] = (live<2||live>3)?1:3; //1 dead cell in new board but without disturbing exisitng set up for simultaneous calculation.
                }
            }
        }
        
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                board[i][j] = board[i][j] == 2 || board[i][j] == 3?1:0;
            }
        }
        
    }
            
    public int count(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int live = 0;
        for(int I = -1;I<=1;++I){
            for(int J =-1;J<=1;++J){
                if((i+I>=0 && i+I<m ) &&(j+J>=0 && j+J<n)){
                    if(I == 0 && 0 == J)
                        continue;
                    else
                        live += board[I+i][J+j]&1; 
                }
            }
        }
        return live;
    }
}