package main.advanced.exceptions;

public class DivisionByZeroException extends Exception{

    @Override
    public String getMessage() {
        return "division by zero warning !";
    }
}
