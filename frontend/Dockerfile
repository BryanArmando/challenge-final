FROM node:16-alpine AS build
 
WORKDIR /usr/src/app
 
ENV PATH /usr/src/app/node_modules/.bin:$PATH
 
COPY ["package.json", "package-lock.json", "./"]
 
RUN npm install
RUN npm install -g @angular/cli
RUN npm install --save-dev @angular-devkit/build-angular
 
COPY . .
 
CMD ng serve --host 0.0.0.0
EXPOSE 4200/tcp



# Build Stage
#FROM node:16-alpine AS build

#RUN mkdir -p /app

#WORKDIR /app

#COPY . .

#RUN npm install

#RUN npm run build --prod

#ENTRYPOINT ["npm","run","start"]

#FROM nginx:1.17.1-alpine

#COPY --from=build /app/dist/sistema-examenes-frontend /usr/share/nginx/html