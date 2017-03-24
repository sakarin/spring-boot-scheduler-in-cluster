package th.co.truecorp.omx.scheduler;

public interface RegisteredSchedulerService {

    boolean ifNoMasterSchedulerRegisterThisScheduler(String schedulerName);

    boolean ifThisSchedulerIsRegisteredAsMasterIncreaseHeartbeat(String schedulerName);
}
