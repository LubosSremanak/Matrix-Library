package matrixLibrary.file;

import matrixLibrary.matrix.Matrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Export<T extends Number> {


    public void createNewFile(String path) {
        try {
            File file = new File(path);
            System.out.println("Path: " + path + file.getName());
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeMatrixToFile(String path, Matrix<T> matrix) {
        try {
            FileWriter myWriter = new FileWriter(path);
            for (int row = 0; row < matrix.getRows(); row++) {
                for (int column = 0; column < matrix.getColumns(); column++) {
                    myWriter.write(matrix.at(row, column).toString());
                    if (column != matrix.getColumns() - 1) {
                        myWriter.write(",");
                    }
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
