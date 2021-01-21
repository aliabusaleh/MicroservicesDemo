From openjdk:8
EXPOSE 8888
copy ./target/config-server-0.0.1-SNAPSHOT.jar config-server-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["wait", "tcp://eureka-server:8761", "java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]