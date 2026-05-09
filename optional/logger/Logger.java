package optional.logger;

import java.util.function.Supplier;

public class Logger {

    private boolean isDebug = false;

    public Logger(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void debug(int message) {
        if (isDebug) {
            System.out.println("DEBUG: " + message);
        }
    }

    public void debug(Supplier<?> supplier) {
        if (isDebug) {
            System.out.println("DEBUG: " + supplier.get());
        }
    }
}
