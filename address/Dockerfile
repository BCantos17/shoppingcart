FROM java:8
VOLUME /tmp
ADD ./target/address-0.0.1-SNAPSHOT.jar address.jar
EXPOSE 55555
RUN bash -c 'touch /address.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/address.jar"]