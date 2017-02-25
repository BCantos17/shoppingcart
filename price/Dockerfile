FROM java:8
VOLUME /tmp
ADD ./target/price-0.0.1-SNAPSHOT.jar price.jar
EXPOSE 23405
RUN bash -c 'touch /price.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/price.jar"]