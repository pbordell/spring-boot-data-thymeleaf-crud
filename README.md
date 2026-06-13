# spring-boot-data-thymeleaf-crud

Este es un proyecto de ejemplo que implementa una aplicación web completa con operaciones **CRUD** (Crear, Leer, Actualizar y Borrar) para la gestión de películas (Movie Manager). Incorpora capacidades avanzadas de **paginación** y **ordenación** de registros.

## 🚀 Características

*   **Spring Boot**: Configuración ágil y servidor embebido para un despliegue rápido.
*   **Thymeleaf**: Motor de plantillas del lado del servidor para renderizar la interfaz de usuario con HTML5/CSS3.
*   **Spring Data JPA / Hibernate**: Capa de persistencia robusta para interactuar con la base de datos de forma orientada a objetos.
*   **Base de datos H2**: Base de datos en memoria ideal para entornos de desarrollo y pruebas rápidas sin configuraciones complejas.
*   **Paginación y Ordenación**: Control eficiente de grandes volúmenes de datos directamente desde la capa de persistencia.
*   **Lombok**: Uso de anotaciones para reducir el código repetitivo (*boilerplate*), como getters, setters y constructores.

## 🛠️ Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

*   Java JDK 8 o superior.
*   Apache Maven.

## 💻 Instalación y Despliegue

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd spring-boot-data-thymeleaf-crud
   ```
3. Ejecuta la aplicación utilizando el plugin de Spring Boot en Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Abre tu navegador web e ingresa a la siguiente dirección:
   ```text
   http://localhost:8080
   ```

---

## ⚙️ Configuración y Consola de Base de Datos (H2)

Al utilizar una base de datos H2 en memoria, la aplicación se reinicia con datos limpios o scripts predefinidos en cada ejecución. 

Puedes acceder a la consola web de administración de H2 para realizar consultas SQL en la siguiente ruta mientras la app esté corriendo:
*   **URL de la consola**: `http://localhost:8080/h2-console`

*(Nota: Asegúrate de revisar el archivo `src/main/resources/application.properties` para verificar las credenciales de acceso `JDBC URL`, `username` y `password` configuradas).*

---

## 📁 Estructura Principal

*   `/src/main/java`: Contiene las entidades (Movie), repositorios de Spring Data, controladores de Spring MVC y servicios.
*   `/src/main/resources/templates`: Archivos HTML con sintaxis de Thymeleaf para las vistas de la aplicación.
*   `pom.xml`: Archivo de configuración de Maven con las dependencias del proyecto (Spring Boot Starter Web, Data JPA, Thymeleaf, H2, Lombok).
