package th.co.truecorp.omx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import th.co.truecorp.omx.model.RegisteredScheduler;
import th.co.truecorp.omx.repo.RegisteredSchedulerRepository;

import java.util.List;

/**
 * Created by sakarin on 24-Mar-17.
 */
@Service
public class RegisteredSchedulerService {
    @Autowired
    RegisteredSchedulerRepository schedulerRepository;

    public RegisteredScheduler findMasterScheduler() {
        List<RegisteredScheduler> schedulers = schedulerRepository.findBySchedulerType(RegisteredScheduler.MASTER_SCHEDULER_TYPE);
        Assert.notNull(schedulers, "The RegisteredScheduler must not be null");
        return schedulers.get(0);
    }
}
