# FHIR Bridge [![CircleCI Status](https://circleci.com/gh/ehrbase/fhir-bridge.svg?style=shield)](https://circleci.com/gh/ehrbase/fhir-bridge)

FHIR Bridge is an official component of [EHRbase](https://ehrbase.org/).
The purpose of the application is to act as a broker between an HL7 FHIR client and an openEHR server.

The implementation is based on [Apache Camel](https://camel.apache.org/) and [Open eHealth Integration Platform](https://github.com/oehf/ipf).

## Releases

##### 2021, May 04
v1.1.1 - Add system scope for SMART on FHIR.

##### 2021, April 27
v1.1.0 - Final release 1.1.0 including the fix for SMART on FHIR.

##### 2021, April 22
v1.1.0-RC3 - Add support for Basic and OAuth 2.0 Authentication.

##### 2021, April 21
v1.1.0-RC2 - Release Candidate 2

##### 2021, April 13
v1.1.0-RC1 - Release candidate that includes major refactoring of the Conversion API and adds support for new FHIR resources and profiles.

##### 2020, November 29
v1.0.0 - First release of the FHIR Bridge application.

## Getting Started

### Prerequisites

* JDK (>= 11.0.2)
* Apache Maven (>= 3.6.0)
* EHRbase (>= v0.14.0)
* [Optional] ELK Stack: Elasticsearch, Kibana and Logstash (>= 7.7.0)

### Build the application

```shell script
$ mvn clean install
```

### Build the application and execute integration tests

```shell script
$ mvn clean install -DskipITs=false
```

:warning: When using `-DskipITs=false` option, please make sure you have an EHRbase instance up and running. The easiest way to achieve that is to use one of the provided docker-compose files in the **docker** folder:

```shell script
# Start up an EHRbase instance
cd docker
docker-compose -f docker-compose-light.yml up
```

### Run the application

```bash
$ java -jar fhir-bridge-1.0.0-SNAPSHOT.jar
```

## Docker and Docker Compose

### Build the Docker image

```
$ mvn clean spring-boot:build-image
```

### Start a Docker container

```bash
$ docker run -p 8888:8888 -e "FHIR_BRIDGE_EHRBASE_BASE_URL=http://172.17.0.1:8080/ehrbase/rest/openehr/v1/" \
             --name=fhir-bridge ehrbase/fhir-bridge
```

### Setup a full environment using Docker Compose

```bash
$ cd docker
$ docker-compose -f docker-compose-full.yml up
```
