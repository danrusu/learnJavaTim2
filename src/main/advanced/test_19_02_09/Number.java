package main.advanced.test_19_02_09;

public enum Number {
    ONE(1), TWO(2), THREE(3);
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public String toString() {
        return value + "";
    }
}
