#!/bin/sh
cd $(dirname $0)
#返回上级目录
# cd ..

#项目名称
PROJECT_NAME=study-springcloud-consumer-rest
#JAR文件
JAR_FILE=study-springcloud-consumer-rest-1.0.jar
#部署目录
DEPLOY_DIR=$(pwd)

#标准输出
STDOUT_LOG=stdout.log
# GC日志
GC_LOG=/xdfapp/logs/$PROJECT_NAME/gc.log

#环境变量
source /etc/profile

#启动参数
JAVA_MEM_OPTS=" -server -Xms256m -Xmx256m -Xmn128m -Xss256k"
JAVA_GC_OPTS=" -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintClassHistogram -XX:-TraceClassUnloading -verbose:gc -Xloggc:"$GC_LOG_FILE
JAVA_OPTS=$JAVA_MEM_OPTS

#获取pid
get_pid() {
  pid=$(ps -ef | grep $JAR_FILE | grep -v grep | awk '{print $2}')
  echo "$pid"
}
#启动
start() {
  echo "Starting server ..."
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    echo "ERROR: Server running on $pid"
    exit 0
  fi
  nohup java $JAVA_OPTS -jar $DEPLOY_DIR/$JAR_FILE >$STDOUT_LOG 2>&1 &
  sleep 1
  pid=$(get_pid)
  if [ $? -eq 0 ]; then
    echo "STARTED PID: $pid"
  else
    echo "ERROR: Start failure![code: $?]"
  fi
  exit 0
}
#停止
stop() {
  echo "Stopping server ... "
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "ERROR: No server to stop!"
    return 0
  fi
  #sudo kill $pid
  /usr/bin/sudo kill -9 $pid
  if [ $? -eq 0 ]; then
    echo "STOPPED PID: $pid"
  else
    echo "ERROR: Stop failure![code: $?]"
    exit 0
  fi
}
#查看状态
status() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "No server running"
  else
    echo "Running on $pid"
  fi
  exit 0
}

#（★）入口
case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
status)
  status
  ;;
restart)
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    stop

  fi
  start
  ;;
*)
  echo "Usage: $0 {start|stop|restart|status}"
  exit 0
  ;;
esac
