#!/bin/bash
#Tags="@End2End"
#set -e


# Waiting for selenoid to start
#docker-compose exec dockerize dockerize -wait tcp://selenoid:4444 -timeout 60s

echo "#######################################################################"
# Run tests
rm -rf ./target 

file="ExecutionLog.txt"
if [ -f $file ] ; then
    rm $file
fi

#docker pull selenoid/chrome:79.0
#docker pull selenoid/vnc:firefox_72.0
#docker pull selenoid/vnc:opera_66.0
#docker pull selenoid/video-recorder:latest-release


docker-compose exec seleniumcode bash -c "mvn clean test $TEST_ARGS"

#Copy Results to Local 

#docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/target/ /private/tmp/target
#docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/ExecutionLog.log/ /private/tmp
#docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/target/ .
#docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/ExecutionLog.log .

docker cp ilexseleniumtests_seleniumcode_1:/cucumber-jvm-template-master/target/ .
docker cp ilexseleniumtests_seleniumcode_1:/cucumber-jvm-template-master/ExecutionLog.log .


#docker-compose build
#Browser=Chrome docker-compose up -d
#http://localhost:8080


