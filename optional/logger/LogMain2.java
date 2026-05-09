package optional.logger;

public class LogMain2 {

    public static void main(String[] args) {
        Logger logger = new Logger(true);
        logger.debug(value100() + value200());

        System.out.println("debug off");
        logger.setDebug(false);
        logger.debug(value100() + value200());
    }

    static int value100() {
        System.out.println("value 100 call");
        return 100;
    }

    static int value200() {
        System.out.println("value 200 call");
        return 200;
    }
}
