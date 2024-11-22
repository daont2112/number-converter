package hus.oop.numbersystem;

import java.math.BigInteger;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;   // Số ban đầu
    protected String convertedNumber;    // Số được chuyển đổi theo cơ số nào đó từ số ban đầu

    public AbstractNumberConverter(MyNumber originalNumber) {
        this.originalNumber = originalNumber;
    }

    /**
     * Thực hiện chuyển đổi số từ biểu diễn số và hệ cơ số ban đầu trong originalNumber
     * sang số có hệ cơ số nào đó. Kết quả số được chuyển đổi được lưu trong biến
     * thành viên convertedNumber.
     */
    @Override
    public final void convert() {
        String decimalNumber = toDecimal();
        this.convertedNumber = decimalTo(decimalNumber);
    }

    /**
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số khác.
     *
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     * <p>
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     * <p>
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /**
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     *
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     * <p>
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        BigInteger result = BigInteger.ZERO;
        String originalNumberPresentation = originalNumber.getNumberPresentation();
        BigInteger radix = BigInteger.valueOf(originalNumber.getRadix());

        for (int i = 0; i < originalNumberPresentation.length(); i++) {
            char digit = originalNumberPresentation.charAt(i);
            int digitValue;
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else {
                digitValue = digit - 'A' + 10;
            }
            result = result.multiply(radix).add(BigInteger.valueOf(digitValue));
        }
        return result.toString();
    }
}
