package matrixLibrary.operations.genericOperations.dataTypes;

import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

public class IntegerGeneric implements GenericOperations<Integer> {

    public static final GenericOperations<Integer> initialization = new IntegerGeneric();

    private IntegerGeneric() {

    }

    @Override
    public Integer add(Integer number1, Integer number2) {
        Integer sum = number1 + number2;
        return sum;
    }

    @Override
    public Integer subtract(Integer number1, Integer number2) {
        return number1 - number2;
    }

    @Override
    public Integer multiply(Integer number1, Integer number2) {
        return number1 * number2;
    }

    @Override
    public Integer setZero() {
        return 0;
    }

    @Override
    public Integer stringToGeneric(String number) {
        return Integer.parseInt(number);
    }
}
