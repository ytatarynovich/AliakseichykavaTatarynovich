java -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -jar apptorun.jar

java -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms6m -Xmx18m -Xmn2m  -XX:PermSize=20m -XX:MaxPermSize=30m -jar apptorun.jar

java -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms3m -Xmx12m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -jar apptorun.jar

java -XX:+UseParallelOldGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m -jar apptorun.jar

java -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -jar apptorun.jar

java -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms2m -Xmx18m -Xmn1m -XX:PermSize=24m -XX:MaxPermSize=36m -jar apptorun.jar

java -XX:+UseParallelGC -XX:ParallelGCThreads=2 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m -jar apptorun.jar

java -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=18m -jar apptorun.jar









