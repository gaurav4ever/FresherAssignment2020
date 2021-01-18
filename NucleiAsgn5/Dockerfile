FROM debian:9-slim AS builder

RUN set -ex && \
    apt-get update && apt-get install -y wget unzip && \
    wget https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz -O jdk.tar.gz -nv && \
    mkdir -p /opt/jdk && \
    tar zxvf jdk.tar.gz -C /opt/jdk --strip-components=1 && \
    rm jdk.tar.gz && \
    rm /opt/jdk/lib/src.zip

RUN /opt/jdk/bin/jlink \
    --module-path /opt/jdk/jmods \
    --verbose \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --output /opt/jdk-minimal \
    --compress 2 \
    --no-header-files


RUN GRPC_HEALTH_PROBE_VERSION=v0.2.0 && \
    wget -qO/bin/grpc_health_probe https://github.com/grpc-ecosystem/grpc-health-probe/releases/download/${GRPC_HEALTH_PROBE_VERSION}/grpc_health_probe-linux-amd64
  

# Second stage, add only our custom jdk9 distro and our app
FROM debian:9-slim
COPY --from=builder /opt/jdk-minimal /opt/jdk-minimal


COPY --from=builder /bin/grpc_health_probe /bin/grpc_health_probe
  


ENV JAVA_HOME=/opt/jdk-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
ENV APP_TIMEZONE=UTC

EXPOSE 6565
ENTRYPOINT ["/launch.sh"]
COPY launch.sh /
RUN chmod +x /launch.sh

RUN chmod +x /bin/grpc_health_probe
  

COPY build/libs/DemoTemplate-*.jar /app.jar