FROM java:8
VOLUME /tmp
ADD ./target/product-0.0.1-SNAPSHOT.jar product.jar
EXPOSE 12894
RUN bash -c 'touch /product.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/product.jar"]