FROM openjdk:18

COPY ./todo_list-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8026

CMD ["java","-jar","app.jar"]