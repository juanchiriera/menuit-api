# Menuit REST API

API REST para el proyecto menuit. 

Hecho con SpringBoot.

Entre otras cosas tiene:
- Spring REST API
- Spring Secutiry.
- MongoDB connector.

Para levantar entorno de DEV ejecutar el run.sh, o los siguientes comandos:
```sh
mvn clean install
export DB_HOST=46.101.211.13
export DB_NAME=menuit_db
java -jar target/api-0.1.2.jar &
```

Tambien se puede configurar el IDE para correr el codigo, pero es importante recordar setear las variables de entorno `DB_HOST=46.101.211.13` y `DB_NAME=menuit_db`.