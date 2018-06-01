FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/border-patrol.jar /border-patrol/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/border-patrol/app.jar"]
