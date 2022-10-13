#Cài đặt phiên bản java mà mình muốn chạy cho application của mình
FROM openjdk:8-slim as build

#Tên của cái wrapper chứa Image
MAINTAINER eazybytes.com

#Add file application jar vào container
COPY target/cards-0.0.1-SNAPSHOT.jar cards-0.0.1-SNAPSHOT.jar

#Thực hiện chạy application
ENTRYPOINT ["java", "-jar", "/cards-0.0.1-SNAPSHOT.jar"]