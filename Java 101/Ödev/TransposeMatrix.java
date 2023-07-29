
public class TransposeMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        printMatrix(matrix);
        System.out.println("------------------");
        printMatrix(transposeMatrix(matrix));

    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}