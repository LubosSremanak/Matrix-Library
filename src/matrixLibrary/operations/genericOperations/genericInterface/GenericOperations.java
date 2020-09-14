package matrixLibrary.operations.genericOperations.genericInterface;

public interface GenericOperations<T extends Number> {

    T add(T number1, T number2);

    T subtract(T number1, T number2);

    T multiply(T number1, T number2);

    T setZero();

    T stringToGeneric(String number);

}

