# FROM docker.io/maven:3.6.3-openjdk-11

FROM docker.io/openjdk@sha256:a087be6f97af249735b34e7db6414e223a38b7459279d1609b0a44d53e894f29

LABEL maintainer="Thales Alves <thales@thalesalv.es>"

WORKDIR /opt/app
RUN apt update -y && apt upgrade -y && \
    apt install -y git maven && \
    git init . && \
    git remote add -f origin https://github.com/mentoria-openshift/cart-service.git && \
    git config core.sparseCheckout true && \
    echo 'eureka-server' >> .git/info/sparse-checkout && \
    git pull origin master && \
    mvn clean install -f /opt/app/eureka-server && \
    chown -R 0 /opt/app && \
    chmod -R g=u /opt/app

EXPOSE 8761
USER 1001

ENTRYPOINT [ "sh", "/opt/app/entrypoint.sh" ]