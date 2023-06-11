# 使用一个基础的Java镜像
FROM openjdk:11-jdk

# 设置工作目录
WORKDIR /app

# 将项目的JAR文件复制到容器中
COPY build/libs/*.jar app.jar

# 暴露应用程序的端口（如果需要）
EXPOSE 3399

# 定义启动命令
CMD ["java", "-jar", "app.jar"]
