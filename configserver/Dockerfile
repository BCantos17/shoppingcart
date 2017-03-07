FROM java:8
VOLUME /tmp
ADD ./wait-for-it.sh wait-for-it.sh
RUN ["chmod", "+x", "wait-for-it.sh"]
ADD ./target/configserver-0.0.1-SNAPSHOT.jar configserver.jar
RUN bash -c 'touch /catalog.jar'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/configserver.jar"]
EXPOSE 7008