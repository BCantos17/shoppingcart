FROM java:8
VOLUME /tmp
ADD ./target/cart-0.0.1-SNAPSHOT.jar cart.jar
EXPOSE 22222
RUN bash -c 'touch /cart.jar'
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/cart.jar"]