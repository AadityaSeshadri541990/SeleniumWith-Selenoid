FROM maven:alpine

COPY ./ ./IlexSeleniumTests

WORKDIR ./IlexSeleniumTests


CMD [ "/bin/sh", "-c", "while sleep 3600; do :; done"]
