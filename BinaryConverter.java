package hus.oop.numbersystem;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        StringBuilder binaryResult = new StringBuilder();
        BigInteger decimalInt = new BigInteger(decimal);
        if (decimalInt.equals(BigInteger.ZERO)) {
            return "0";
        }
        while (decimalInt.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divideAndRemainder = decimalInt.divideAndRemainder(BigInteger.TWO);
            BigInteger remainder = divideAndRemainder[1];
            binaryResult.insert(0, remainder);
            decimalInt = divideAndRemainder[0];
        }
        return binaryResult.toString();
    }

    /**
     * Trả về số được biểu diễn trong hệ cơ số 2.
     *
     * @return
     */
    @Override
    public MyNumber getNumber() {
        return new MyNumber(this.convertedNumber, 2);
    }
}
