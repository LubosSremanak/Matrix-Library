package matrixLibrary.operations.genericOperations.dataTypes;

import matrixLibrary.dataTypes.UnsignedInteger;
import matrixLibrary.operations.genericOperations.genericInterface.GenericOperations;

public class UnsignedIntegerGeneric implements GenericOperations<UnsignedInteger> {

    public static final GenericOperations<UnsignedInteger> initialization = new UnsignedIntegerGeneric();

private UnsignedIntegerGeneric(){

}
    @Override
    public UnsignedInteger add(UnsignedInteger number1, UnsignedInteger number2) {
            UnsignedInteger number=new UnsignedInteger(number1.getNumber()+number2.getNumber());
        return number;
    }

    @Override
    public UnsignedInteger subtract(UnsignedInteger number1, UnsignedInteger number2) {
        UnsignedInteger number=new UnsignedInteger(number1.getNumber()-number2.getNumber());
        return number;
    }

    @Override
    public UnsignedInteger multiply(UnsignedInteger number1, UnsignedInteger number2) {
        UnsignedInteger number=new UnsignedInteger(number1.getNumber()*number2.getNumber());
        return number;
    }

    @Override
    public UnsignedInteger setZero() {
        UnsignedInteger zero = new UnsignedInteger(0);
        return zero;
    }

    @Override
    public UnsignedInteger stringToGeneric(String number) {
        UnsignedInteger num = new UnsignedInteger(Integer.parseInt(number));

        return num;
    }
}
