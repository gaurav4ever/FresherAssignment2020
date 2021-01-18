CURRENT=$(shell pwd)

OS := $(shell uname)


################ configuration
SEM_VER_IMAGE := asia.gcr.io/kubernets-sdk/semver:v2
CHARTNAME_SERVICE := nuclei-demotemplate-service
CHART_VERSION := $(subst v,,${tag})

ifndef JAVA_IMAGE
JAVA_IMAGE := asia.gcr.io/kubernets-sdk/java-docker:v2
endif

ifndef NAMESPACE
NAMESPACE := biz-staging
endif 

ifndef PROFILE
PROFILE := dev
endif

ifndef DOCKER_REGISTRY
DOCKER_REGISTRY := docker08.helpchat.in:5000
endif

########################################
# PART 1
#  Building the Docker Image and Pushing it to Repo (2)


build-application:
	sudo docker run  -v ${PWD}:/app ${JAVA_IMAGE} sh -c "./gradlew demotemplate:build -x test"



skaffold-build-application:  #Docker Image Build and Push
	VERSION=`cat VERSION` skaffold build -f skaffold.yaml -p ${PROFILE} -n ${NAMESPACE} --default-repo ${DOCKER_REGISTRY}

skaffold-deploy-application:  #Docker Image Build and Push
	VERSION=`cat VERSION` skaffold deploy -f skaffold.yaml -p ${PROFILE} -n ${NAMESPACE} --default-repo ${DOCKER_REGISTRY}


tag-application:
ifeq ($(OS),Darwin)
	sed -i "" -e "s|repository: .*|repository: ${DOCKER_REGISTRY}\/nuclei-demotemplate|" Chart/nuclei-demotemplate/values.yaml
	sed -i "" -e "s|tag:.*|tag: ${tag}|" Chart/nuclei-demotemplate/values.yaml
else ifeq ($(OS),Linux)
	sed -i -e "s|repository: .*|repository: ${DOCKER_REGISTRY}\/nuclei-demotemplate|" Chart/nuclei-demotemplate/values.yaml
	sed -i -e "s|tag:.*|tag: ${tag}|" Chart/nuclei-demotemplate/values.yaml
else
	echo "platfrom $(OS) not supported to tag with"
	exit -1
endif


publish-application:
	helm package --version ${CHART_VERSION} --app-version ${CHART_VERSION} Chart/nuclei-demotemplate
	-curl -X DELETE ${CHART_API}/nuclei-demotemplate/${CHART_VERSION}
	helm push nuclei-demotemplate-${CHART_VERSION}.tgz ${CHART_REPO}

get-tags:
	$(eval CHARTVERSION_OLD := $(shell grep -w version Chart/${CHARTNAME_SERVICE}/Chart.yaml | sed -e 's/^.\{9\}//'))
	echo ${CHARTVERSION_OLD}
	$(eval VERSION := $(shell docker run ${SEM_VER_IMAGE} sh -c "./app up patch ${CHARTVERSION_OLD}"))
	echo ${VERSION} > VERSION

