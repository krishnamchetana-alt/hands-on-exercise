public class Logger {
    // static instance of Logger
    private static Logger instance;

    // private constructor to prevent instantiation
    private Logger() {
    }

    // public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // example logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
