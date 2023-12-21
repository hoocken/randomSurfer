import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double[][] matrix = {new double[]{1.0 / 4, 1.0 / 4, 1.0 / 4, 1.0 / 4}, new double[]{1.0/3, 0, 1.0/3, 1.0/3}, new double[] {0,0,0,0}, new double[] {0,1.0/2,1.0/2,0} };
        double[][] copy = {new double[]{1.0 / 4, 1.0 / 4, 1.0 / 4, 1.0 / 4}, new double[]{1.0/3, 0, 1.0/3, 1.0/3}, new double[] {0,0,0,0}, new double[] {0,1.0/2,1.0/2,0} };

        double[][] add = new double[4][4];
        double[][] result = new double[4][4];
        for (int i = 0; i < 500; i++) {
            result = matrixMultiplication(matrix, copy);
            copy = result;
            add = matrixAddition(add, copy);
        }
        result = matrixMultConstant(add, 1.0/500);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static double[][] matrixMultiplication(double[][] m1, double[][] m2) {
        double[][] result = new double[4][];

        for (int i = 0; i < m1.length; i++) {

            result[i] = vectorMultiplication(m1, column(m2, i));
        }

        result = transpose(result);

        return result;

    }

    public static double[] vectorMultiplication(double[][] matrix, double[] vector) {
        double[] res = new double[vector.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] += matrix[i][j]*vector[j];
            }
        }

        return res;
    }

    public static double[] column(double[][] arr, int column) {
        if (arr == null) return new double[] {};
        double[] d = new double[arr.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = arr[i][column];
        }
        return d;
    }

    public static double[][] transpose(double[][] a) {
        // TODO
        double[][] transposed = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++){
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }

    public static double[][] matrixAddition(double[][] m1, double[][] m2) {
        double[][] res = new double[m1.length][m1[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return res;
    }

    public static double[][] matrixMultConstant(double[][] matrix, double constant) {
        double[][] res = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = matrix[i][j]*constant;
            }
        }
        return res;
    }
}