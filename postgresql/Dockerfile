FROM postgres:14.4-alpine
MAINTAINER Uladzimir

ADD /events_service/ddl/*.sql /docker-entrypoint-initdb.d
ADD /classifier_service/ddl/*.sql /docker-entrypoint-initdb.d
ADD /user_service/ddl/*.sql /docker-entrypoint-initdb.d
ADD /user_service/dml/*.sql /docker-entrypoint-initdb.d
