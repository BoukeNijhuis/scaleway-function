# Function handler written in Java

A simple example to run Java Serverless Functions on top of Scaleway Serverless Containers

The example is strongly inspired by this [Flask project written in Python](https://github.com/scaleway/serverless-scaleway-functions/tree/master/examples/container) with PORT definition by Environment variable.

## Setup

- Install and configure [Serverless Framework](https://www.serverless.com/)
- Install the [Scaleway plugin](https://github.com/scaleway/serverless-scaleway-functions)
- For local testing install Java and Maven

### Build and Deploy

The java-container folder contains a classic maven project with pom.xml and Dockerfile

- Build maven project and test locally

```
 mvn clean package
```

- Deploy your project to Scaleway Containers
  The Dockerfile build your maven project and create a new docker image.

```
 serverless deploy
```

### MacOS

```
cd java-container
docker build -t rg.fr-par.scw.cloud/bouke/solar-panel-checker  --platform linux/amd64 .
docker image push rg.fr-par.scw.cloud/bouke/solar-panel-checker:latest
cd ..
serverless deploy
```

### One-time steps

```
docker login rg.fr-par.scw.cloud/bouke -u nologin --password-stdin <<< [SCALEWAY SECRET KEY]
```