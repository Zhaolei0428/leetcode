public class FourtyEight {
    //找规律的方法
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length == 1)
            return;
        for(int i=0; i<matrix.length/2; i++) {
            for(int j=i; j<matrix.length-1-i; j++) {
                int col1 = matrix.length-1-i;
                int row1 = j;
                int col2 = matrix.length-1-j;
                int row2 = matrix.length-1-i;
                int col3 = i;
                int row3 = matrix.length-1-j;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row3][col3];
                matrix[row3][col3] = matrix[row2][col2];
                matrix[row2][col2] = matrix[row1][col1];
                matrix[row1][col1] = temp;
            }
        }
    }
    //两次反转
//    public void rotate(int[][] matrix) {
//        int len = matrix.length;
//        int[][] result = new int[len][len];
//        for (int i = 0; i < len; i++) {
//            for (int j = matrix[i].length - 1; j >= 0; j--) {
//                result[j][i] = matrix[i][j];
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                matrix[i][matrix[i].length - 1-j] = result[i][j];
//            }
//        }
//    }
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        FourtyEight fourtyEight = new FourtyEight();
        fourtyEight.rotate(a);
        for(int[] row: a){
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
