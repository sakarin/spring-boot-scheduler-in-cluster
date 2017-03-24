package th.co.truecorp.omx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@RedisHash("{scheduler}")
public class RegisteredScheduler implements Serializable {

    private static final long serialVersionUID = -6666637843591286669L;

    public static final String MASTER_SCHEDULER_TYPE = "M";

    @Id
    private String id;
    @Indexed
    private String schedulerName;
    @Indexed
    private String schedulerType;
    @Indexed
    private String heartbeat;


    RegisteredScheduler(final String schedulerType) {
        this.schedulerType = schedulerType;
    }

    public RegisteredScheduler(String id, String schedulerName, String schedulerType, String heartbeat) {
        this.id = id;
        this.schedulerName = schedulerName;
        this.schedulerType = schedulerType;
        this.heartbeat = heartbeat;
    }

    public RegisteredScheduler() {
    }

    static RegisteredScheduler newInstanceOfMasterScheduler() {
        return new RegisteredScheduler(MASTER_SCHEDULER_TYPE);
    }

    public String getId() {
        return this.id;
    }

    public String getSchedulerName() {
        return this.schedulerName;
    }

    public String getSchedulerType() {
        return this.schedulerType;
    }

    public String getHeartbeat() {
        return this.heartbeat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public void setSchedulerType(String schedulerType) {
        this.schedulerType = schedulerType;
    }

    public void setHeartbeat(String heartbeat) {
        this.heartbeat = heartbeat;
    }
}
