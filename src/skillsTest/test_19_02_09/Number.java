package skillsTest.test_19_02_09;

public enum Number {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int value;

    private Number(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }

}