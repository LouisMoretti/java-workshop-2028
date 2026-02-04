package fr.epita.assistants.maths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixTests {

    @Test
    void testMatrixConstructor1() {
        int[][] rawMatix = {
                {1, 1},
                {1, 1}
        };

        Matrix matrix = new Matrix(rawMatix);
        assert (matrix.getMatrix() == rawMatix);
    }

    @Test
    void testMatrixConstructor2() {
        int[][] rawMatix = null;

        Matrix matrix = new Matrix(rawMatix);
        assert (matrix.getMatrix() == null);
    }

    @Test
    void testMatrixConstructor3() {
        int[][] rawMatix = {{42}};

        Matrix matrix = new Matrix(rawMatix);
        assert (matrix.getMatrix() == rawMatix);
    }

    @Test
    void testMatrixConstructor4() {
        int[][] rawMatix = {{1, 1, 1, 42, 1, 1, 1}};

        Matrix matrix = new Matrix(rawMatix);
        assert (matrix.getMatrix() == rawMatix);
    }

    @Test
    void testMatrixEquals1() {
        int[][] rawMatix = {
                {1, 1},
                {1, 1}
        };

        Matrix matrix1 = new Matrix(rawMatix);
        Matrix matrix2 = new Matrix(rawMatix);
        assert (matrix1.equals(matrix2));
    }

    @Test
    void testMatrixEquals2() {
        int[][] rawMatix1 = {
                {1, 1},
                {1, 1}
        };

        int[][] rawMatix2 = {
                {2, 2},
                {2, 2}
        };

        Matrix matrix1 = new Matrix(rawMatix1);
        Matrix matrix2 = new Matrix(rawMatix2);
        assert (!matrix1.equals(matrix2));
    }

    @Test
    void testMatrixEquals3() {
        int[][] rawMatix1 = {
                {1, 1}
        };

        int[][] rawMatix2 = {
                {1},
                {1}
        };

        Matrix matrix1 = new Matrix(rawMatix1);
        Matrix matrix2 = new Matrix(rawMatix2);
        assert (!matrix1.equals(matrix2));
    }

    @Test
    void testMatrixEquals4() {
        int[][] rawMatix1 = {{1}};
        int[][] rawMatix2 = {{42}};

        Matrix matrix1 = new Matrix(rawMatix1);
        Matrix matrix2 = new Matrix(rawMatix2);
        assert (!matrix1.equals(matrix2));
    }

    @Test
    void testMatrixEquals5() {
        int[][] rawMatix1 = {{1}};

        Matrix matrix1 = new Matrix(rawMatix1);
        Matrix matrix2 = new Matrix(null);
        assert (!matrix1.equals(matrix2));
    }

    @Test
    void testMatrixMultiply1() {
        int[][] rawMatix = {
                {1, 1},
                {1, 1}
        };

        int[][] result = {
                {2, 2},
                {2, 2}
        };

        Matrix matrix1 = new Matrix(rawMatix);
        Matrix matrix2 = new Matrix(rawMatix);

        assertArrayEquals (matrix1.multiply(matrix2).getMatrix(), result);
    }

    @Test
    void testMatrixMultiply2() {
        int[][] rawMatix = {
                {42, 42},
                {42, 42}
        };

        int[][] indentity = {
                {1, 0},
                {0, 1}
        };

        Matrix matrix1 = new Matrix(rawMatix);
        Matrix matrix2 = new Matrix(indentity);

        assertArrayEquals (matrix1.multiply(matrix2).getMatrix(), rawMatix);
    }
}
