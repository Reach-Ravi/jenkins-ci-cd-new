FROM amazoncorretto:17
WORKDIR /ravi
COPY ./target/jenkinscicdnew.jar /ravi
CMD ["java","-jar","jenkinscicdnew.jar"]