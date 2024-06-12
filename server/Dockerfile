FROM ubuntu:focal

RUN apt-get update && \
    apt-get install -y curl git && \
    curl -sL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y nodejs && \
    npm install -g typescript && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /home/app/server

COPY src ./src
COPY package*.json ./
COPY tsconfig.json ./

RUN npm install
RUN npx tsc

EXPOSE 9000

CMD ["node", "dist/server.js"]