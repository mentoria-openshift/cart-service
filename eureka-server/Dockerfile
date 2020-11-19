FROM docker.io/maven:3.6.3-openjdk-11

LABEL maintainer="Thales Alves <thales@thalesalv.es>"

WORKDIR /opt/app
RUN git init . && \
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