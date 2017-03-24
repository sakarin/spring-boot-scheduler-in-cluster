package th.co.truecorp.omx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import th.co.truecorp.omx.jobs.Job1;
import th.co.truecorp.omx.jobs.Job2;

@Configuration
class JobsConfig {
    @Bean
    Job1 job1() {
        return new Job1();
    }

    @Bean
    Job2 job2() {
        return new Job2();
    }
}
