FROM docker.io/centos:8

LABEL maintainer="Thales Alves <thales@thalesalv.es>" \
    io.openshift.tags="java,spring,netflix,eureka" \
    io.k8s.description="Eureka server for OpenShift" \
    io.openshift.expose-services="8761:8761" \
    openshift.io/display-name="Eureka Server"

ENV JAVA_HOME="/opt/openjdk11" \
    MAVEN_HOME="/opt/maven" \
    PATH="$PATH:$MAVEN_HOME/bin"

COPY [ "entrypoint.sh", "/opt/app/" ]

WORKDIR /opt

RUN yum update -y && \
    yum install -y wget tar git && \
    wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz && \
    wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz && \
    tar xvzf openjdk-11.0.2_linux-x64_bin.tar.gz && \
    tar xvzf apache-maven-3.6.3-bin.tar.gz && \
    mv apache-maven-3.6.3 /opt/maven && \
    mv jdk-11.0.2 /opt/openjdk11 && \
    chmod -R +x $MAVEN_HOME/bin $JAVA_HOME/bin

WORKDIR /opt/app

RUN git init . && \
    git remote add -f origin https://github.com/mentoria-openshift/cart-service.git && \
    git config core.sparseCheckout true && \
    echo 'eureka-server' >> .git/info/sparse-checkout && \
    git pull origin master && \
    $MAVEN_HOME/bin/mvn clean install -f /opt/app/eureka-server && \
    chown -R 1001:0 /opt/app && \
    chmod -R g=u /opt/app

EXPOSE 8761

USER 1001

ENTRYPOINT [ "sh", "/opt/app/entrypoint.sh" ]