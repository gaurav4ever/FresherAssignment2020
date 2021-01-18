#!/bin/bash

check_var(){
  if [ -z "$1" ]; then
    >&2 echo "error: missing environmental variable $2. exit"
    exit 1
  fi
}

check_var "${APP_TIMEZONE}" "APP_TIMEZONE"

TIMEZONE=${APP_TIMEZONE:-none}

JAVA_OPTS="-Duser.timezone=${TIMEZONE} -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} ${OPTIONS}"

exec java ${JAVA_OPTS} -jar /app.jar