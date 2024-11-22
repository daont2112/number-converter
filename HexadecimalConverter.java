package hus.oop.numbersystem;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {
    private static final char[] hexChars = "0123456789ABCDEF".toCharArray();
    public HexadecimalConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        BigInteger decimalInt = new BigInteger(decimal);
        if (decimalInt.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (decimalInt.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divideAndRemainder = decimalInt.divideAndRemainder(BigInteger.valueOf(16));
            BigInteger remainder = divideAndRemainder[1];
            result.insert(0, hexChars[remainder.intValue()]);
            decimalInt = divideAndRemainder[0];
        }
        return result.toString();
    }

    /**
     * Trả về số được biểu diễn trong hệ cơ số 16.
     *
     * @return
     */
    @Override
    public MyNumber getNumber() {
        return new MyNumber(this.convertedNumber, 16);
    }
}
