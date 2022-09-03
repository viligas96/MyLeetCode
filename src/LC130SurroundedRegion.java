public class LC130SurroundedRegion {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        if (row <= 2 || col <= 2)return;

        boolean[][] flipped = new boolean[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                flipped[i][j] = true;
            }
        }

        for (int i = 0; i < col; i++){
                flip(0,i,board,flipped);
                flip(row -1 ,i,board,flipped);
        }
        for (int j = 0; j < row; j++){
                flip(j, 0, board, flipped);
                flip(j, col - 1, board, flipped);
        }
        for (int i = 0; i <row; i ++){
            for (int j = 0; j < col; j++){
                if (flipped[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void flip(int i, int j, char[][] board, boolean[][] flipped){
        if (i < 0 || i >= board.length)return;
        if (j < 0 || j >= board[0].length)return;
        if (board[i][j] != 'O')return;
        if (!flipped[i][j]) return;

        flipped[i][j] = false;

        flip(i+1, j, board, flipped);
        flip(i, j+1, board, flipped);
        flip(i, j-1, board, flipped);
        flip(i-1, j, board, flipped);
    }
}
