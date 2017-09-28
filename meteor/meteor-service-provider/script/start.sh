#!/bin/bash
runEnv=dev
port=8080
if [ runEnv == 'dev' ];then
    logPATH=logs/
else
    logPATH=/opt/vipkid/meteor/logs/
fi
if [ ! -d $logPATH ];then
 mkdir -p $logPATH;
fi
nohup java -Xmx3000m -Xms3000m -XX:MaxMetaspaceSize=300m -XX:MetaspaceSize=128m  -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -verbose:gc -Xloggc:$logPATH/gc.log -XX:CMSInitiatingOccupancyFraction=80 -XX:+UseCMSCompactAtFullCollection -XX:+PrintGCDateStamps   -XX:+PrintGCDetails -jar luce-service-provider-1.0-SNAPSHOT.jar --spring.profiles.active=$runEnv --server.port=$port 1> $logPATH/nohup.log 2>&1 &