#
# BUILD WITH THE FOLLOWING COMMAND:
# docker build -t serenitydojo/serenity-petclinic-ui .
#
# RUN A CONTAINER WITH THE FOLLOWING COMMAND:
# docker run -p 8080:80 --detach --name ui serenitydojo/serenity-petclinic-ui
#

FROM node:13.12.0 as build-stage
# Create a directory where our app will be placed
RUN mkdir -p /app

# Change directory so that our commands run inside this new directory
WORKDIR /app

# Copy dependency definitions
COPY package*.json /app/

# Install dependecies
RUN npm install
RUN npm install -g @angular/cli@8.0.3

# Get all the code needed to run the app
COPY . /app/

ARG configuration=production
RUN ng build --output-path=./dist/out --configuration $configuration

#FROM nginx:1.15
FROM nginx:1.16.0-alpine

## Remove default Nginx website
RUN rm -rf /usr/share/nginx/html/*

COPY ./dev/nginx.conf /etc/nginx/nginx.conf

COPY --from=build-stage /app/dist/out/ /usr/share/nginx/html

