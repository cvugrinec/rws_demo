This contains 3 projects that are needed for the demo for rws

  * rws_javaClassicDemo; demonstrates how to build and deploy a simple java project to JBoss EAP using the jboss-as maven plugin
  * rws_javaClassicDocker; demonstrates how to build and deploy a simple java project (based on the previous demo) but in stead of directly deploying to jboss...it will build this project on top of an existing docker image (an image that contains a running jboss) and create a new image with the deployment added as well, this is being done with the jolokia maven-docker plugin
  * rws_Demo; demonstrates the usage of the following technologies: java/maven/docker/fabric8/kubernetes/openshift....a simple java project, being build as a docker image, this docker image is being deployed with the fabric8 plugin, which is configured to deploy this docker image to a kubernetes/openshift environment. In stead of setting up a complete environment with atomic rhel/ openshift kubernetes and fabric8, there is a vagrant image available that delivers you the complete stack with everything installed already....I am using this vagrant image in the demo as well:  http://fabric8.io/guide/getStartedVagrant.html

please note in order to run the demo that creates the Dockerfile, you need to have a running docker-machine environment... for e.g.
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.101:2376"
export DOCKER_CERT_PATH="/Users/chris/.docker/machine/machines/default"
export DOCKER_MACHINE_NAME="default"
# Run this command to configure your shell:
# eval "$(docker-machine env default)"

you can build the docker image with the following command: mvn clean package docker:build

this will result in a Dockerfile in the target directory and based on that file a docker image in your docker repository, have a look with the docker images command...
