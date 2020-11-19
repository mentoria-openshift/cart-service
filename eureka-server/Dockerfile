FROM docker.io/openjdk:11.0.9.1-jre-buster

LABEL maintainer="Thales Alves <thales@thalesalv.es>"

RUN apt update -y && apt upgrade -y && \
    git clone ${EUREKA_SERVER_REPO} /opt/app

WORKDIR /opt/app

RUN mvn clean install && \
    chown -R 0 /opt/app && \
    chmod -R g=u /opt/app

EXPOSE 8761
USER 1001

ENTRYPOINT [ "sh", "/opt/app/entrypoint.sh" ]