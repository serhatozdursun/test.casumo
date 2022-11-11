FROM maven:3.8.5-openjdk-18

WORKDIR app
COPY . /app/



RUN git clone https://github.com/serhatozdursun/test.casumo.git --branch master
RUN cd test.casumo &&\
    mvn clean install