FROM openjdk 
COPY /build/libs/EMPLOYEE-SVC-0.0.1-SNAPSHOT.jar /usr/app/ 
WORKDIR /usr/app 
RUN sh -c 'touch EMPLOYEE-SVC-0.0.1-SNAPSHOT.jar' 
ENTRYPOINT ["java","-jar","EMPLOYEE-SVC-0.0.1-SNAPSHOT.jar"] 
