package hus.oop.numbersystem;

import java.math.BigInteger;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        StringBuilder result = new StringBuilder();
        BigInteger decimalInt = new BigInteger(decimal);
        if (decimalInt.equals(BigInteger.ZERO)) {
            return "0";
        }
        while (decimalInt.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divideAndRemainder = decimalInt.divideAndRemainder(BigInteger.valueOf(8));
            result.insert(0, divideAndRemainder[1]);
            decimalInt = divideAndRemainder[0];
        }
        return result.toString();
    }

    /**
     * Trả về số được biểu diễn trong hệ cơ số 8.
     *
     * @return
     */
    @Override
    public MyNumber getNumber() {
        return new MyNumber(this.convertedNumber, 8);
    }
}
