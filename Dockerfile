FROM openjdk:8
COPY ./target/dup-cloud-parser-1.0-SNAPSHOT-jar-with-dependencies.jar .
EXPOSE 8080
CMD java -jar dup-cloud-parser-1.0-SNAPSHOT-jar-with-dependencies.jar