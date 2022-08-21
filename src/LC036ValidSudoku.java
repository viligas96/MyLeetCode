import java.util.HashSet;
import java.util.Objects;

public class LC036ValidSudoku {
    public static boolean isValidSudoku(String[][] board){
        String[][] new_board = new String[9][9];

        for (int i = 0; i < 9; i++){
            HashSet<String> str = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(board[i][j], ".")) {
                    new_board[i][j] = board[i][j] + "";
                } else {
                    String sb = board[i][j] + i + j;
                    new_board[i][j] = sb;
                }
                str.add(new_board[i][j]);
            }
            if (str.size() != 9){
                return false;
            }
        }

        for (int i = 0; i < 9; i++){
            HashSet<String> str = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                str.add(new_board[j][i]);
            }
            if (str.size() != 9){
                return false;
            }
        }
        for (int i = 0; i < 9; i+=3){
            for (int j = 0; j < 9; j+=3){
                HashSet<String> str = new HashSet<>();
                for (int k = i; k < i+3; k++){
                    for (int l = j; l < j+3; l++){
                        str.add(new_board[k][l]);
                    }
                }
                if (str.size() != 9){
                    System.out.println(str.size());
                    System.out.println(str.clone());
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[][] board = new String[][]{{"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
    {".",".",".","4","1","9",".",".","5"},
    {".",".",".",".","8",".",".","7","9"}};
        String[][] board1 = new String[][]{{".",".",".",".","5",".",".","1","."},
                {".","4",".","3",".",".",".",".","."},
                {".",".",".",".",".","3",".",".","1"},
                {"8",".",".",".",".",".",".","2","."},
                {".",".","2",".","7",".",".",".","."},
                {".","1","5",".",".",".",".",".","."},
                {".",".",".",".",".","2",".",".","."},
                {".","2",".","9",".",".",".",".","."},
                {".",".","4",".",".",".",".",".","."}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board1));

    }

}

