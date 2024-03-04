FROM ubuntu:latest

RUN apt-get update

RUN apt-get install -y openjdk-17-jdk

RUN apt-get install -y maven

COPY . /home

WORKDIR /home

ENV DB_URL=jdbc:mysql://*.*.*.*:3306/todos_list

ENV DB_USERNAME=root

ENV DB_PASSWORD=root

EXPOSE 8026

CMD ["mvn","spring-boot:run"]
