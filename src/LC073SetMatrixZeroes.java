import java.util.*;
public class LC073SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> row0 = new HashSet<>();
        HashSet<Integer> col0 = new HashSet<>();

        int width = matrix.length;
        int length = matrix[0].length;

        for (int i = 0; i < width; i++){
            for (int j = 0; j < length; j++){
                if (matrix[i][j] == 0){
                    row0.add(i);
                    col0.add(j);
                }
            }
        }

        for (int row: row0){
            for (int i = 0; i < width; i++){
                matrix[row][i] = 0;
            }
        }
        for (int col: col0){
            for (int j = 0; j < length; j++){
                matrix[j][col] = 0;
            }
        }
    }
    public static void main (String[] args){

    }
}
