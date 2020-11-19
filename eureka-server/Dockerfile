FROM docker.io/centos:8

LABEL maintainer="Thales Alves <thales@thalesalv.es>" \
    io.openshift.tags="java,spring,netflix,eureka" \
    io.k8s.description="Eureka server for OpenShift" \
    io.openshift.expose-services="8761:8761" \
    openshift.io/display-name="Eureka Server"

ENV JAVA_HOME="/usr/lib/jvm/java-11-openjdk-11.0.8.10-0.el8_2.x86_64" \
    MAVEN_HOME="/opt/apache-maven-3.6.3" \
    PATH="$PATH:$MAVEN_HOME/bin"

WORKDIR /opt

RUN yum update -y && \
    yum upgrade -y && \
    yum install -y wget tar java-11-openjdk-devel java-11-openjdk git && \
    wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz && \
    tar xvzf apache-maven-3.6.3-bin.tar.gz && \
    chmod -R +x $MAVEN_HOME/binaries

WORKDIR /opt/app

RUN git init . && \
    git remote add -f origin https://github.com/mentoria-openshift/cart-service.git && \
    git config core.sparseCheckout true && \
    echo 'eureka-server' >> .git/info/sparse-checkout && \
    git pull origin master && \
    $MAVEN_HOME/bin/mvn clean install -f /opt/app/eureka-server && \
    chown -R 0 /opt/app && \
    chmod -R g=u /opt/app

EXPOSE 8761

USER 1001

ENTRYPOINT [ "sh", "/opt/app/entrypoint.sh" ]