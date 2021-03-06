#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#镜像作者
LABEL maintainer="wangzhj<zerowzj@163.com>" app="study-springcloud-client-rest"
#
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#
ARG JAR_FILE
ENV DEPLOY_DIR=/app \
    JAR_NAME=study-springcloud-client-rest-1.0.jar
#
RUN mkdir ${DEPLOY_DIR}
ADD ${JAR_FILE} ${DEPLOY_DIR}
#
WORKDIR ${DEPLOY_DIR}
ENTRYPOINT ["java", "-jar", "study-springcloud-client-rest-1.0.jar"]