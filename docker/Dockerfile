FROM maven:3.8.5-openjdk-18

RUN apt update -y

WORKDIR app
COPY . /app/
RUN apt install -y wget unzip


RUN git clone https://github.com/onurkasaburi/com.brooksource.git --branch master
RUN cd com.brooksource &&\
    mvn clean install