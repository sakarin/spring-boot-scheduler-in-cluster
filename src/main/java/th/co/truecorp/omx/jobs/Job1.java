package th.co.truecorp.omx.jobs;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import static org.slf4j.LoggerFactory.getLogger;

public class Job1 {

    private static final Logger log = getLogger(Job1.class);

    @Scheduled(fixedRate = 1000)
    public void execute() {
        log.info("Executing job1");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Release Job1 ************");
    }
}
