FROM java:8
VOLUME /tmp
ADD ./target/zuulgateway-0.0.1-SNAPSHOT.jar zuulgateway.jar
EXPOSE 8723
RUN bash -c 'touch /zuulgateway.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/zuulgateway.jar"]