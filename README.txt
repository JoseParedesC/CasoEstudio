Estudio de caso enfocado al marketplace de licores (cervezas, vinos, etc)

Integrantes: Danna Marcela Contreras Frias y José Dionisio Paredes Caballero
Estudiantes de Desarrollo de sotfware en Fundación Universitaria Tecnologico Comfenalco

Las tecnologías usadas en el desarrollo de este proyecto son:

Frontend: Angular 12.1.0
Backend: Spring Boot 2.5.4

Posdata, al clonar el repositorio debe instalar todas la depedencias de Angular
para poder levantar el servidor y hacer las pruebas en su localhost
El comando para hacer esta instrucción es 'npm i' o 'npm install' (en la raiz del proyecto)
Cabe aclarar que debe tener instalado node Js en su maquina.

La funcionalidad básica del proyecto cuenta de unos servicios REST creados con Spring Boot, apoyandonos de Hibernate y
usando al máximo todas sus funcionalidades como Jpa para la creación de persistencias y relaciones foraneas entre nuestras tablas,
la base de datos que usamos para este proyecto es PostgreSQL.
Y en el front se consume todos los servicios REST para mostrar la información en pantalla, así como también se modifica la información para mostrar
lo necesario al cliente, se hace uso de muchas herramientas que tiene Angular para crear los formularios, componentes, directivas, pipes, etc
Para cumplir con un flujo de la aplicación de manera satisfactoria, así como también se implementar una aquitectura de recomendada por lo creadores de angular.
(core, shared, features).

Recursos:

Para la creación del usuario usado en este proyecto:
CREATE ROLE cavaweb WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'cavaweb';

Para la creación de la base de datos usada en este proyecto:
CREATE DATABASE cava
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;