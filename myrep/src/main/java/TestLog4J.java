import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4J {

    public static Logger log;

    public static void main(String[] args) {
        log = LogManager.getLogger(TestLog4J.class);

        log.error("This is a Debug log12312312344445555");
        log.info("This is an Info log123123123");
        log.info("Error in a Project123123123");

    }
}
