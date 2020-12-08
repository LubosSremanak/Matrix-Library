package matrixLibrary.matrix;

import matrixLibrary.file.Export;
import matrixLibrary.file.Import;
import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;
import matrixLibrary.operations.matrixOperations.MatrixOperations;


import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Number> {
    private int rows, columns;
    private List<List<T>> matrix;
    private final Import<T> tImport;
    private final Export<T> tExport;
    private MatrixOperations matrixOperations;


    public Matrix(String path, GenericOperations<T> genericOperations) {
        this.matrix = new ArrayList<>();
        this.tImport = new Import<T>(genericOperations);
        this.tExport = new Export<>();
        importMatrixFromFile(path);
    }



    public Matrix(int rows, int columns, GenericOperations<T> genericOperations) {

        this.matrixOperations = new MatrixOperations(genericOperations);
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ArrayList<List<T>>();
        this.tImport = new Import<>(genericOperations);
        this.tExport = new Export<>();

    }

    public void importMatrixFromFile(String path) {
        this.tImport.setSizeFromFile(path);
        this.rows = tImport.getRows();
        this.columns = tImport.getColumns();
        this.matrix = tImport.getMatrixFromFile(path).getMatrix();
    }

    public void exportMatrixToFile(String path) {
        tExport.createNewFile(path);
        tExport.writeMatrixToFile(path, this);
    }

    public void createMatrix(T number) {

        for (int row = 0; row < this.rows; row++) {
            matrix.add(new ArrayList<>(this.rows));
            for (int column = 0; column < this.columns; column++) {

                matrix.get(row).add(column, number);
            }
        }
    }


    public void createMatrix(T[][] matrix) {
        this.rows=matrix.length;
        this.columns=matrix[0].length;
        for (int row = 0; row < this.rows; row++) {
            this.matrix.add(new ArrayList<>(this.rows));
            for (int column = 0; column < this.columns; column++) {

                this.matrix.get(row).add(column, matrix[row][column]);
            }
        }
    }


    public void printMatrix(String name) {
        System.out.println(name + "[" + this.rows + "x" + this.columns + "] =");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("        " + " [");
            for (int column = 0; column < this.columns; column++) {
                System.out.print(this.matrix.get(row).get(column));
                if (column != columns - 1)
                    System.out.print(",");
            }
            System.out.print("]");

            System.out.println();
        }

        System.out.println("\n");
    }


    public void addition(Matrix<T> matrix1, Matrix<T> matrix2) {
        this.rows=matrix1.rows;
        this.columns=matrix1.columns;
        this.matrix = this.matrixOperations.add(matrix1, matrix2).getMatrix();
    }

    public void subtraction(Matrix<T> matrix1, Matrix<T> matrix2) {
        this.rows=matrix1.rows;
        this.columns=matrix1.columns;
        this.matrix = this.matrixOperations.subtract(matrix1, matrix2).getMatrix();
    }

    public void multiplication(Matrix<T> matrix1, Matrix<T> matrix2) {
        this.rows=matrix1.rows;
        this.columns=matrix2.columns;
        this.matrix = this.matrixOperations.multiply(matrix1, matrix2).getMatrix();
    }

    public T at(int row, int column) {
        return this.matrix.get(row).get(column);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<List<T>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    public void add(int row, int column, T value) {
        this.matrix.get(row).add(column, value);
    }
}

