FROM openjdk:18

COPY target/* /app

WORKDIR /app

EXPOSE 8026

CMD ["java","-jar","todo_list-0.0.1-SNAPSHOT.jar"]