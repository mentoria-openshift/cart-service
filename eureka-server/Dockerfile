FROM docker.io/openjdk:11.0.9.1-jre-buster

LABEL maintainer="Thales Alves <thales@thalesalv.es>"

RUN apt update -y && apt upgrade -y && \
    mkdir -p /opt/app

WORKDIR /opt/app
COPY [ "entrypoint.sh", "target/eureka-server-0.0.1-SNAPSHOT.jar", "/opt/app/" ]

EXPOSE 8761

ENTRYPOINT [ "sh", "entrypoint.sh" ]