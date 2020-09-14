package matrixLibrary.dataTypes;


public class UnsignedInteger <T extends Number>extends Number {

    private final int MAX = 32767;
    private final int MIN = 0;
    private int number;

    public UnsignedInteger(int number) {
        overFlow(this);
        this.number = number;
    }

    @Override
    public String toString() {
        overFlow(this);
        return String.valueOf(number);
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        overFlow(this);
    }

    private void overFlow(UnsignedInteger number) {
        if (number.number > MAX) {
            setNumber(MIN);
        }
        if (number.number < MIN) {
            setNumber(MAX);
        }
    }

    @Override
    public int intValue() {
        return Integer.valueOf(getNumber());
    }

    @Override
    public long longValue() {
        return Long.valueOf(getNumber());
    }

    @Override
    public float floatValue() {
        return Float.valueOf(getNumber());
    }
    @Override
    public double doubleValue() {
        return Double.valueOf(getNumber());
    }

}
