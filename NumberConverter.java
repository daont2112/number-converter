package hus.oop.numbersystem;

public interface NumberConverter {
    /**
     * Trả về số được biểu diễn trong hệ cơ số nào đó.
     * @return
     */
    MyNumber getNumber();

    /**
     * Thực hiện chuyển đổi số từ biểu diễn trong hệ cơ số này sang hệ cơ số khác.
     */
    void convert();
}
