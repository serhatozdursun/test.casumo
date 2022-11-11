package exeptions;

public class UpperCaseException extends RuntimeException{
    public UpperCaseException(char letter) {
        super(String.format("\"%s\" is upper case",letter));
    }
}
