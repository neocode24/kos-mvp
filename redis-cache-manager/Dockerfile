FROM ktis-bastion01.container.ipc.kt.com:5000/openjdk:8-jdk-alpine
ADD ./target/manage-cache-svc.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
