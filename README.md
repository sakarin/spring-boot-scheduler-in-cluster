# spring-boot-scheduler-in-cluster

This Project port from scheduled-in-cluster(https://github.com/bgawel/scheduled-in-cluster) h2db base to redis.

This is a scheduler implementation based on Spring scheduling which executes jobs only on one node in a cluster environment.
Each node tries to register a scheduler; the first one wins, the rest ones are disabled.
Once the node - which successfully registered the scheduler - is down, the other node replaces it.

Advantages:
* it uses only one table to synchronize nodes,
* works with a standard Spring @Scheduled annotation.

Disadvantages:
* it does not spread jobs execution among all nodes; all jobs are executed on one node.

Demo:

1) Start node 1 in a cluster by running
```
java -jar spring-boot-scheduled-in-cluster-1.0-SNAPSHOT.jar
```

2) Start node 2 in the cluster by running
```
java -Dscheduler.name=node2 -jar spring-boot-scheduled-in-cluster-1.0-SNAPSHOT.jar
```

**Expected:**
Only node 1 executes jobs

4) Stop node 1

**Expected:**
After ~90 seconds node 2 executes jobs
