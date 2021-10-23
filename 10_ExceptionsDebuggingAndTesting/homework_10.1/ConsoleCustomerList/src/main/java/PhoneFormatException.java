import java.util.regex.Matcher;

public class PhoneFormatException extends Exception {

    public PhoneFormatException() {
    }

    public PhoneFormatException(String message) {
        super(message);
    }

    public PhoneFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneFormatException(Throwable cause) {
        super(cause);
    }

    public PhoneFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
