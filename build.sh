#!/bin/bash
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#

# See: https://sipb.mit.edu/doc/safe-shell/
set -e
set -u

. ./build.include
init "$@"

DEFAULT_MVN_REPO=${HOME}/.m2/repository

if command -v mvn >/dev/null 2>&1; then
  MVN_REPO=$(mvn help:evaluate -Dexpression=settings.localRepository | grep -E '^([a-zA-Z]:|/)')
  echo "Detected Maven, mounting local repo at ${MVN_REPO}"
else
  MVN_REPO=${DEFAULT_MVN_REPO}
  echo "Maven not detected, mounting local repo at default path: ${DEFAULT_MVN_REPO}";
fi

sudo chown -R $USER ${HOME}/.m2
docker_exec run -it --rm --name build-che       \
       -v "$MVN_REPO:/home/user/.m2/repository" \
       -v "$PWD":/home/user/che-build           \
       -w /home/user/che-build                  \
       codenvy/che-dev                          \
       mvn clean install

# Run dockerfiles build
./dockerfiles/cli/build.sh
./dockerfiles/init/build.sh
./dockerfiles/server/build.sh

# Push images
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
docker push convertigo/convertigo-che-cli:nightly
docker push convertigo/convertigo-che-init:nightly
docker push convertigo/convertigo-che-server:nightly
