# **CHALLENGE KRUGER:** 

## BACKEND

> ######  **Desarrollador:** Bryan Armando Quisaguano Casa

> ######  Perfil: [@BryanArmando](https://github.com/BryanArmando)

## Arquitectura del proyecto:

![imagen](https://github.com/BryanArmando/challenge-final/blob/master/arquitectura.jpg)

## Ejecución de proyectos (local):

1. Clonar el proyecto
```
git clone https://github.com/BryanArmando/challenge-final.git
```

2. Abrir una terminal en la carpeta del proyecto con nombre **fullstack**, con la finalidad de instalar las dependencias del archivo **pom.xml**, se debe aplicar el comando:
```
mvn install
```

3. Abrir el proyecto en un IDE de preferencia Intellij Idea, con el cual puede suplir el paso anterior ya que descarga las dependencias de forma automática.

4. Dirigirse al archivo **application.properties** ubicado en el directorio **src/main/resources** y colocar las credenciales de la base de datos local a utilizar, por ejemplo:
```
spring.datasource.url=jdbc:mysql://localhost:3306/tubase
spring.datasource.url=root
spring.datasource.password=1234
```
5. Correr el proyecto desde el archivo principal con nombre **FullstackApplication.java**. 

Con ello se inicia el proyecto y se ejecuta de manera local en el puerto 8080 por defecto. 
```
http://localhost:8080
```
6. Realizar el mismo procedimiento con las carpetas **dataclient** y **gen**.

7. Se recomienda en el archivo properties tener las configuraciones ya preestablecidas como vienen al descargar el proyecto, como el ddl y los puertos y que ambas apunten a la misma base de datosse de datos local:
```
spring.datasource.url=jdbc:mysql://localhost:3306/tubase
spring.datasource.url=root
spring.datasource.password=1234
```
8. Ejecutar desde sus respectivos archivos principales y su documentación en swagger las podrá visualizar en las siguentes rutas por defecto:
```
http://localhost:8081/doc/swagger-ui/index.html#/
http://localhost:8082/doc/swagger-ui/index.html#/
```

9. Se recomienda abrir la carpeta **frontend** con visual studio por convención, ejecutar el siguiente comando y descargar los paquetes necesarios.
```
npm install
```

10. Ejecutar el proyecto con el comando **ng serve** y en se despliega el sistema en el puerto por defecto: 
```
http://localhost:4200
```
> ######  **En caso de cambiar los puertos de spring boot tambien debe cambiar el puerto dentro de angular del cual se realiza el consumo de los endpoints** 
