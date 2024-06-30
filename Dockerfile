FROM openjdk:17-alpine
COPY ./ /usr/src/mini-inventario-supabase
WORKDIR /usr/src/mini-inventario-supabase
RUN ./mvnw clean install
CMD ["java", "-jar", "target/mini-inventario-supabase-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080