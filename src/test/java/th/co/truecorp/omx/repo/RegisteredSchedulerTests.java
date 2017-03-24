package th.co.truecorp.omx.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import th.co.truecorp.omx.model.RegisteredScheduler;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisteredSchedulerTests {
    @Autowired
    private RegisteredSchedulerRepository schedulerRepository;


    @Test
    public void newSchedulerTest() {
        String heartbeat = String.valueOf(System.currentTimeMillis());
        RegisteredScheduler scheduler = new RegisteredScheduler("1001", "Node1", "M", heartbeat);
        schedulerRepository.save(scheduler);
        final RegisteredScheduler retrievedScheduler = schedulerRepository.findOne(scheduler.getId());
        assertEquals(scheduler.getId(), retrievedScheduler.getId());
    }

    @Test
    public void findSchedulerByName(){
        List<RegisteredScheduler> schedulers = schedulerRepository.findBySchedulerName("Node1");
        assertEquals(schedulers.get(0).getSchedulerName(), "Node1");
    }

}
