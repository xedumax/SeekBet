Documentación del Proyecto Backend Java
1. Descripción General
Este proyecto corresponde a una API REST desarrollada en Java 17 utilizando Spring Boot 3, como parte de una evaluación técnica para el rol de Backend Java Developer. La API permite la gestión de clientes, el cálculo de métricas asociadas y la exposición de la información mediante endpoints REST documentados con estándares de la industria.
________________________________________
2. Tecnologías Utilizadas
•	Java 17: versión LTS utilizada para el desarrollo.
•	Spring Boot 3.4.x: framework principal para la construcción de la API.
•	Spring Web: creación de endpoints REST.
•	Spring Data JPA: acceso a datos y persistencia.
•	MySQL: base de datos relacional.
•	Flyway: control de versiones y migraciones de base de datos.
•	Spring Validation: validación de datos de entrada.
•	Spring Security: configurado de forma básica (sin autenticación obligatoria para el scope del reto).
•	Spring Actuator: monitoreo básico de la aplicación.
•	SpringDoc OpenAPI (Swagger): documentación de la API.
•	Maven: gestión de dependencias y build.
________________________________________
3. Arquitectura del Proyecto
El proyecto sigue una arquitectura en capas inspirada en Clean Architecture, separando claramente:
•	Domain: modelos de dominio y contratos (ports / use cases).
•	Application: implementación de servicios y casos de uso.
•	Infrastructure: controllers REST, configuración, repositorios JPA y adaptadores externos.
Esta separación facilita el mantenimiento, las pruebas y la extensibilidad del sistema.
________________________________________
4. Funcionalidades Implementadas
4.1 Registro de Clientes
Permite crear nuevos clientes registrando:
•	Nombre
•	Apellido
•	Edad
•	Fecha de nacimiento
4.2 Listado de Clientes con Cálculo Derivado
Se obtiene el listado completo de clientes junto con un dato derivado, como una fecha estimada de evento futuro (por ejemplo, esperanza de vida calculada a partir de la edad).
4.3 Métricas de Clientes
El sistema calcula métricas agregadas sobre los clientes registrados:
•	Promedio de edad
•	Desviación estándar de edades
Estas métricas se exponen mediante un endpoint específico.
________________________________________
5. Persistencia y Base de Datos
•	Se utiliza MySQL como motor de base de datos.
•	Spring Data JPA abstrae el acceso a datos.
•	Flyway gestiona las migraciones de esquema, garantizando consistencia entre entornos.
•	RDS Aws Service donde se creó una instancia para utilizar la base de datos MySql 
 
________________________________________
6. Documentación de la API
La API está documentada usando OpenAPI 3 mediante SpringDoc, lo cual permite:
•	Visualizar todos los endpoints disponibles
•	Probar las operaciones directamente desde el navegador
•	Facilitar el consumo por parte de otros desarrolladores

URLs disponibles:
•	Swagger UI: http://18.188.38.194:8080/swagger-ui/index.html#
•	OpenAPI JSON: http://18.188.38.194:8080/v3/api-docs
________________________________________
7. Manejo de Validaciones
Se utiliza Spring Validation para asegurar que los datos de entrada cumplan las reglas de negocio básicas (por ejemplo, edad válida, campos obligatorios, formatos correctos).
El foco del proyecto está en la lógica de negocio y la claridad del diseño, por lo que el manejo avanzado de excepciones se deja fuera del alcance de esta entrega.
________________________________________
8. Seguridad
Spring Security se encuentra incluido y configurado de forma básica. Para el alcance de este reto:
•	No se exige autenticación para consumir los endpoints
•	La configuración permite una futura extensión hacia mecanismos de autenticación y autorización
________________________________________
9. Construcción y Ejecución
Compilar el proyecto:
mvn clean package
Ejecutar la aplicación:
Este .jar se despliega la instancia EC2 creada en Aws 18.188.38.194
