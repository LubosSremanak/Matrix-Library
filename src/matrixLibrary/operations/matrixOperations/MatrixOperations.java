package matrixLibrary.operations.matrixOperations;

import matrixLibrary.matrix.Matrix;
import matrixLibrary.matrix.matrixExceptions.MatrixExceptions;
import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

import java.util.ArrayList;

public class MatrixOperations<T extends Number> {

    private final GenericOperations<T> genericOperations;

    public MatrixOperations(GenericOperations<T> genericOperations) {
        this.genericOperations = genericOperations;
    }


    public boolean isDifferent(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRows() == matrix2.getRows()) {
            return matrix1.getColumns() != matrix2.getColumns();
        }
        return true;
    }

    public boolean isMultiplied(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumns() == matrix2.getRows()) {
            return true;
        }
        return false;
    }

    public Matrix<T> add(Matrix<T> matrix1, Matrix<T> matrix2) {

        if (isDifferent(matrix1, matrix2)) {
            throw new MatrixExceptions("Matrices must be same");
        }

        Matrix<T> newMatrix = new Matrix<T>(matrix1.getRows(), matrix1.getColumns(), genericOperations);

        for (int row = 0; row < matrix1.getRows(); row++) {
            newMatrix.getMatrix().add(new ArrayList<T>(matrix1.getRows()));
            for (int column = 0; column < matrix1.getColumns(); column++) {

                T value = genericOperations.add(matrix1.at(row, column), matrix2.at(row, column));
                newMatrix.add(row, column, value);
            }
        }
        return newMatrix;
    }

    public Matrix<T> subtract(Matrix<T> matrix1, Matrix<T> matrix2) {

        if (isDifferent(matrix1, matrix2)) {
            throw new MatrixExceptions("Matrices must be same");
        }

        Matrix<T> newMatrix = new Matrix<T>(matrix1.getRows(), matrix1.getColumns(), genericOperations);

        for (int row = 0; row < matrix1.getRows(); row++) {
            newMatrix.getMatrix().add(new ArrayList<T>(matrix1.getRows()));
            for (int column = 0; column < matrix1.getColumns(); column++) {

                T value = genericOperations.subtract(matrix1.at(row, column), matrix2.at(row, column));
                newMatrix.add(row, column, value);
            }
        }
        return newMatrix;
    }

    public Matrix<T> multiply(Matrix<T> matrix1, Matrix<T> matrix2) {

        if (!isMultiplied(matrix1, matrix2)) {
            throw new MatrixExceptions("The number of columns in the first matrix must be equal to the number of rows in the second.");
        }

        Matrix<T> newMatrix = new Matrix<T>(matrix1.getRows(), matrix2.getColumns(), genericOperations);

        for (int row = 0; row < matrix1.getRows(); row++) {
            newMatrix.getMatrix().add(new ArrayList<T>(matrix1.getRows()));
            for (int rr = 0; rr < matrix2.getColumns(); rr++) {

                T xx = genericOperations.setZero();
                for (int column = 0; column < matrix1.getColumns(); column++) {
                    xx = genericOperations.add(xx, genericOperations.multiply(matrix1.at(row, column), matrix2.at(column,rr)));
                }
                newMatrix.add(row, rr, xx);
            }
        }

        return newMatrix;
    }
}

