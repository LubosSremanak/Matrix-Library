package matrixLibrary.file;

import matrixLibrary.matrix.Matrix;
import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Import<T extends Number> {

    private final GenericOperations<T> genericOperations;
    private int rows, columns;

    public Import(GenericOperations<T> genericOperations) {

        this.genericOperations = genericOperations;

    }

    public void printMatrix(String path) {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setSizeFromFile(String path) {
        int row = 0, column = 1;

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                row++;
                if (row == 1) {
                    for (int i = 0; i < data.length(); i++) {
                        if (data.charAt(i) == ',')
                            column++;
                    }
                }
            }

            myReader.close();
            this.rows = row;
            this.columns = column;
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            e.printStackTrace();
        }
    }

    public Matrix<T> getMatrixFromFile(String path) {
        setSizeFromFile(path);
        Matrix<T> newMatrix = new Matrix<T>(this.rows, this.columns, genericOperations);

        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            for (int row = 0; row < this.rows; row++) {
                newMatrix.getMatrix().add(new ArrayList<T>(this.rows));
                for (int column = 0, x = 0; column < this.columns; column++) {

                    String number = readNumber(bufferedReader);

                    newMatrix.add(row, column, genericOperations.stringToGeneric(number));

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return newMatrix;
    }

    private String readNumber(BufferedReader bufferedReader) throws IOException {
        String number = "";
        char w = (char) bufferedReader.read();
        while (w != ',' && w != '\n') {
            number += w;
            w = (char) bufferedReader.read();
        }

        return number;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


}
