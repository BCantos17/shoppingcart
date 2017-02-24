FROM java:8
VOLUME /tmp
ADD ./target/apigateway-0.0.1-SNAPSHOT.jar apigateway.jar
EXPOSE 8675
RUN bash -c 'touch /apigateway.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/apigateway.jar"]