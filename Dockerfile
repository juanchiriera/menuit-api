FROM java
MAINTAINER Juan Cruz Riera - juancriera94@gmail.com
COPY ./target/api-0.1.2.jar /root/app.jar
EXPOSE 8080
ENV DB_HOST="46.101.211.13" DB_NAME="menuitdb"
CMD ["/usr/bin/java", "-jar", "/root/app.jar"]