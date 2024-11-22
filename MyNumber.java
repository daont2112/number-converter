package hus.oop.numbersystem;

public class MyNumber {
    private String numberPresentation;  // Biểu diễn số ban đầu
    private int radix;                  // Cơ số của số ban đầu

    public MyNumber(String originalNumber, int radix) {
        this.numberPresentation = originalNumber;
        this.radix = radix;
    }

    public String getNumberPresentation() {
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        this.numberPresentation = numberPresentation;
    }

    public int getRadix() {
        return radix;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(radix).
     * @return
     */
    @Override
    public String toString() {
        return this.numberPresentation + "(" + this.radix + ")";
    }
}