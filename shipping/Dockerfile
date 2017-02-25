FROM java:8
VOLUME /tmp
ADD ./target/shipping-0.0.1-SNAPSHOT.jar shipping.jar
EXPOSE 7923
RUN bash -c 'touch /shipping.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/shipping.jar"]