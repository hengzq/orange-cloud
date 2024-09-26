FROM registry.cn-wulanchabu.aliyuncs.com/hengzq/eclipse-temurin:17-jre-focal
# 如果registry.cn-wulanchabu.aliyuncs.com/hengzq/eclipse-temurin:17-jre-focal获取失败
# 使用镜像:eclipse-temurin:17-jre-focal

LABEL authors="hengzq"

# 设置工作目录
WORKDIR /orange

# 复制jar文件
COPY target/orange-ai-service.jar app.jar

# 设置环境变量
ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms256m -Xmx1024m"
ENV SPRING_PROFILES_ACTIVE=prod

# 暴露端口
EXPOSE 80

# 运行应用
CMD ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar"]
