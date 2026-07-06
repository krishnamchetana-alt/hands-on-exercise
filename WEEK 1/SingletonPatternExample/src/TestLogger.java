public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // check if both references point to the same object
        System.out.println(logger1 == logger2); // should print true

        // test logging
        logger1.log("This is a test message.");
    }
}
