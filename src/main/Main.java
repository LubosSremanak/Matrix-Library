package main;

import matrixLibrary.matrix.Matrix;
import matrixLibrary.operations.genericOperations.dataTypes.DoubleGeneric;
import matrixLibrary.operations.genericOperations.dataTypes.IntegerGeneric;
import matrixLibrary.operations.genericOperations.dataTypes.UnsignedIntegerGeneric;
import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

public class Main {


    public static void main(String[] args) {
        GenericOperations myDouble=DoubleGeneric.initialization;
        GenericOperations myInteger=IntegerGeneric.initialization;
        GenericOperations myUnsignedInteger=UnsignedIntegerGeneric.initialization;
        Double[][] array ={
                {10.5,1.6,2.8,3.9}, {10.5,1.6,2.8,3.9}, {10.5,1.6,2.8,3.9}, {10.5,1.6,2.8,3.9}
        };
        String path = "Matica6.csv";

        Matrix matrixA=new Matrix(4,3,myInteger);
        Matrix matrixB=new Matrix(4,3,myInteger);
        Matrix matrixC=new Matrix(3,2,myInteger);

        Matrix matrixD=new Matrix(2,2,myDouble);
        Matrix matrixE=new Matrix(2,3,myInteger);

        Matrix matrixF=new Matrix(3,3,myInteger);
        Matrix matrixG =new Matrix(3,3,myDouble);


        matrixA.createMatrix(8);
        matrixA.printMatrix("A");

        matrixB.createMatrix(8);
        matrixB.printMatrix("B");

        matrixD.createMatrix(2);
        matrixD.printMatrix("D");

        matrixE.createMatrix(3);
        matrixE.printMatrix("E");

        matrixG.createMatrix(array);
        matrixG.printMatrix("G");

        matrixC.addition(matrixA,matrixB);
        matrixC.printMatrix("A+B");

        matrixC.subtraction(matrixA,matrixB);
        matrixC.printMatrix("A-B");



        matrixG.exportMatrixToFile(path);

        matrixF.multiplication(matrixD,matrixE);
        matrixF.printMatrix("D*E");

        matrixD.importMatrixFromFile(path);
        matrixD.printMatrix("Imported D");
    }
}