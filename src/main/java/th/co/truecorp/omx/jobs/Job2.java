package th.co.truecorp.omx.jobs;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import static org.slf4j.LoggerFactory.getLogger;

public class Job2 {

    private static final Logger log = getLogger(Job2.class);

    @Scheduled(fixedRate = 500)
    public void execute() {
        log.info("Executing job2");
    }
}
