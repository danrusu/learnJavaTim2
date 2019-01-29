package main.advanced.exceptions;

public class Divider {

    private float val1;
    private float val2;

    public Divider(float val1, float val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public float getResult() throws DivisionByZeroException {
        if(val2 == 0){
            throw new DivisionByZeroException();
        }

        return val1 / val2;
    }
}
