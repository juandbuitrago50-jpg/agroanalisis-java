
# Agroanálisis - Java

## Descripción del proyecto

Agroanálisis es un proyecto de software orientado a la gestión y análisis de información relacionada con los suelos destinados al cultivo de aguacate.

Este módulo fue desarrollado en Java y permite realizar operaciones de registro, consulta, actualización y eliminación de usuarios mediante una conexión a una base de datos MySQL utilizando JDBC.

## Tecnologías utilizadas

- Java 17.
- Apache Maven.
- MySQL.
- MySQL Connector/J.
- JDBC.
- Visual Studio Code.
- Git y GitHub.

## Estructura del proyecto

```text
agroanalisis-java/
├── src/
│   ├── main/
│   │   └── java/com/agroanalisis/
│   │       ├── App.java
│   │       └── ConexionBD.java
│   └── test/
│       └── java/com/agroanalisis/
│           └── AppTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Funcionalidades

1. Registrar usuarios.
2. Consultar usuarios.
3. Actualizar usuarios.
4. Eliminar usuarios.
5. Conectar con la base de datos MySQL.

## Base de datos

El proyecto utiliza una base de datos MySQL llamada `agroanalisis`.

La conexión se realiza mediante JDBC. Para ejecutar el proyecto se debe contar con MySQL instalado y configurar los datos de conexión correspondientes.

## Ejecución del proyecto

1. Instalar Java 17 o una versión compatible.
2. Instalar Apache Maven.
3. Crear la base de datos `agroanalisis` en MySQL.
4. Configurar la conexión en `ConexionBD.java`.
5. Abrir una terminal en la carpeta del proyecto.
6. Ejecutar:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.agroanalisis.App"
```

## Control de versiones

El proyecto utiliza Git para el control de versiones y GitHub para alojar el repositorio.

## Autor

Juan David Buitrago Castaño

Proyecto formativo - SENA
