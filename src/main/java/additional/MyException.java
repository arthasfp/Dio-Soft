package additional;

public class MyException extends Exception{
    private final String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public MyException(String errorCode) {
        this.errorCode = errorCode;

    }
}