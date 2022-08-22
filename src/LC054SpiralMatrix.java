import java.util.*;
public class LC054SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int width = matrix.length;
        int length = matrix[0].length;

        int len = Math.min(width,length);

        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < (len+1)/2; i++){
            spiralRec(matrix, ret,i);
        }
        return ret;
    }

    public static void spiralRec(int[][] matrix, List<Integer> ret, int i){
        int width = matrix.length;
        int length = matrix[0].length;

        if (width == 2*i + 1){
            for (int ind1 =i; ind1 < length - i; ind1++){
                ret.add(matrix[i][ind1]);
            }
            return;
        }
        else if (length == 2*i + 1){
            for (int ind2 = i; ind2 < width - i; ind2++){
                ret.add(matrix[ind2][i]);
            }
            return;
        }

        for (int j = i; j < length - i - 1 ;  j++) {
            ret.add(matrix[i][j]);
        }

        for (int k = i; k < width - i - 1; k++){
            ret.add(matrix[k][length - i - 1]);
        }

        for (int l = length - i - 1; l > i; l--){
            ret.add(matrix[width-i-1][l]);
        }

        for (int m = width - i - 1; m > i; m--){
            ret.add(matrix[m][i]);
        }

    }
    public static void main (String[] args){
        int[][] matrix1 = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[][] matrix2 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix3 = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}};
        //System.out.println(spiralOrder(matrix1));
        //System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
    }


}
