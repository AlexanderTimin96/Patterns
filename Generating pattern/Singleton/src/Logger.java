import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger = null;
    private int num = 1;
    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + formater.format(date) + " " + num++ + "] " + msg);
    }
}
