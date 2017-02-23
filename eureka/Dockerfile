FROM java:8
VOLUME /tmp
ADD ./target/eureka-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8761
RUN bash -c 'touch /eureka.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]