FROM java:8

MAINTAINER MAGIC_KANG
VOLUME /tmp
ENV TZ=Asia/Shanghai

# 设置时区
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD /target/cosmetic-0.0.1-SNAPSHOT.jar /app.jar

#暴露端口
EXPOSE 9527

ENTRYPOINT ["java","-jar","/app.jar"]