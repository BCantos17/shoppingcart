FROM java:8
VOLUME /tmp
ADD ./target/creditcard-0.0.1-SNAPSHOT.jar creditcart.jar
EXPOSE 44444
RUN bash -c 'touch /creditcart.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/creditcart.jar"]