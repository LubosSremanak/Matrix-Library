package matrixLibrary.operations.genericOperations.dataTypes;

import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

public class DoubleGeneric implements GenericOperations<Double> {

    public static final GenericOperations<Double> initialization = new DoubleGeneric();

    private DoubleGeneric() {

    }


    @Override
    public Double add(Double number1, Double number2) {
        return number1 + number2;
    }

    @Override
    public Double subtract(Double number1, Double number2) {
        return number1 - number2;
    }

    @Override
    public Double multiply(Double number1, Double number2) {
        return number1 * number2;
    }

    @Override
    public Double setZero() {
        Double val = 0.0;
        return val;
    }

    @Override
    public Double stringToGeneric(String number) {
        return Double.parseDouble(number);
    }

}