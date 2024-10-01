FROM ubunto:latest

WORKDIR /app
RUN apt-get update && apt-get install -y net-tools

COPY program.sh .
RUN cdmod +x program.sh
ENTRYPOINT ["./program.sh"]