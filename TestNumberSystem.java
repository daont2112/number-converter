package hus.oop.numbersystem;

import java.util.Random;

public class TestNumberSystem {
    private static final String baseString = "0123456789ABCDEF";
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên nằm trong đoạn [2, 16] được sinh ngẫu nhiên.
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Integer loopTimes = 3;

        for (int i = 0; i < loopTimes; i++) {
            convertRandomNumber();
        }

    }

    private static void convertRandomNumber() {
        Integer radix = random(2, 16);
        Integer numberLength = random(10, 30);

        String randomNumber = randomNumber(numberLength, radix);
        MyNumber myNumber = new MyNumber(randomNumber, radix);

        BinaryConverter binaryConverter = new BinaryConverter(myNumber);
        binaryConverter.convert();

        OctalConverter octalConverter = new OctalConverter(myNumber);

        octalConverter.convert();

        HexadecimalConverter hexConverter = new HexadecimalConverter(myNumber);

        hexConverter.convert();




        System.out.println("Original number: " + myNumber);
        System.out.println("radix: " + radix);
        System.out.println("Binary: " + binaryConverter.convertedNumber);
        System.out.println("Octal: " + octalConverter.convertedNumber);
        System.out.println("Hexadecimal: " + hexConverter.convertedNumber);
        System.out.println(" ");

    }

    private static String convertResult(NumberConverter converter) {
        converter.convert();
        return converter.getNumber().getNumberPresentation();
    }

    private static Integer random(Integer min, Integer max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }

    private static String randomNumber(Integer length, Integer radix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(baseString.charAt(random(0, radix-1)));
        }

        return sb.toString();
    }
}
