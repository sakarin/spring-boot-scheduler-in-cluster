package th.co.truecorp.omx.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import th.co.truecorp.omx.model.RegisteredScheduler;

import java.util.List;

@Repository
public interface RegisteredSchedulerRepository extends CrudRepository<RegisteredScheduler, String> {

    List<RegisteredScheduler> findBySchedulerType(String schedulerType);
}
