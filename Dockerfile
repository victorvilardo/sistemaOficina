FROM maven:3.8-openjdk-17 as build
WORKDIR /usr/src/app
COPY . .
RUN mvn package

FROM eclipse-temurin:17-jdk
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/sistemaOficina-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
