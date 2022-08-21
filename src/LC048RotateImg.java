import java.util.Arrays;

public class LC048RotateImg {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 1) return;
        for (int i = 0; i < len/2; i++){
            rSing(matrix, i);
        }
    }

    public static void rSing(int[][] matrix, int i){
        int len = matrix.length;
        if (i == len/2) return;

        int tmp = matrix[i][i];

        for (int j = i; j < len - i - 1; j++){
            swap(matrix, i, j, j,len-i - 1);
        }
        for (int k = len-1-i; k >i; k--){
            swap(matrix, len-i-1, k, k,i);
        }
        for (int l = i; l < len-i-1; l++){
            swap(matrix, i,l, len-i-1, len-1-l);
        }
    }

    public static void swap(int[][] matrix, int i, int j, int k, int l){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = tmp;
    }

    public static void main (String[] args){
        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
