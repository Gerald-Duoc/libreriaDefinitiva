Integrantes:
*Jonathan Garrido, Benjamin Astudillo, Gerald Cortes
DEPENDE

https://github.com/Gerald-Duoc/Inventario.git
/
https://github.com/Gerald-Duoc/sucursal.git
/
https://github.com/Benjamin-A-L-duocuc/login_libreria.git
/
https://github.com/Benjamin-A-L-duocuc/registro_usuario_libreria.git
/
https://github.com/Benjamin-A-L-duocuc/libreria_envio.git
/
https://github.com/Benjamin-A-L-duocuc/libreria_tienda_web.git
/
https://github.com/Benjamin-A-L-duocuc/ventas_libreria.git(Merma: Clonacion repositorio https://github.com/jon4707/venta_libro.git se le fue la luz)
/
https://github.com/jon4707/proveedor_libro.git
/
https://github.com/Gerald-Duoc/MoniteoreoGeneral.git

# 📚 Sistema de Microservicios para Cadena de Librerías

Este repositorio contiene el backend del sistema de una cadena de librerías, implementado con una arquitectura de microservicios en Spring Boot. Cada microservicio gestiona un dominio específico y se comunican entre sí mediante HTTP/REST.

## 📋 Requisitos previos

Asegúrate de tener instalado lo siguiente:

- *JDK 25* (versión necesaria para compilar y ejecutar los microservicios)
- *XAMPP* (con Apache y MySQL) – se usará *solo MySQL* para las bases de datos. Apache es opcional.
- *Postman* (o cualquier cliente REST) para probar los endpoints
- *Visual Studio Code* (con extensiones para Java y Spring Boot) – también puede usarse IntelliJ IDEA o Eclipse
- *Git* (opcional, para clonar el repositorio)

> *Nota:* Los microservicios ya están completamente desarrollados (incluyen sus archivos application.properties, controladores, servicios, repositorios, etc.). No es necesario modificar ninguna configuración de Spring ni agregar dependencias. Solo se deben crear las bases de datos vacías con los nombres exactos que se indican más abajo.

## 🗄️ Configuración de bases de datos (PASO OBLIGATORIO)

### 1. Encender XAMPP
- Abre el panel de control de XAMPP.
- Inicia el servicio *MySQL* (puerto por defecto 3306).  
  Apache no es necesario para el funcionamiento de los microservicios, pero puedes dejarlo encendido si lo prefieres.

### 2. Crear las bases de datos vacías
Accede a *phpMyAdmin* (o a tu cliente MySQL favorito, como MySQL Workbench o línea de comandos) y ejecuta *exactamente* los siguientes comandos SQL:

```sql
CREATE DATABASE tienda_Web;
CREATE DATABASE envio;
CREATE DATABASE registro_usuario;
CREATE DATABASE login_usuario;
CREATE DATABASE sucursaldb;
CREATE DATABASE inventariodb;
CREATE DATABASE proveedor;
CREATE DATABASE ventas;
Los nombres deben ser escritos tal cual aparecen arriba, respetando mayúsculas y minúsculas.
No se deben crear tablas manualmente; los microservicios las generarán automáticamente al ejecutarse.

🚀 Ejecución de los microservicios
Cada microservicio es un proyecto Spring Boot independiente. Sigue estos pasos para cada uno:

Abre la carpeta del microservicio en VSCode (o tu IDE).

Navega hasta el archivo que contiene el método main (el único archivo .java que está al mismo nivel que las carpetas model, service, repository, controller, dto, exception). Su nombre suele ser algo como NombreMicroservicioApplication.java.

Haz clic derecho sobre ese archivo y selecciona Run Java (o usa el botón ▶️ en la parte superior derecha).

Espera a que el microservicio levante correctamente. En los logs deberías ver algo como:
Started Application in X seconds (JVM running for Y).

Orden recomendado (por dependencias entre microservicios)
Aunque técnicamente puedes encenderlos en cualquier orden, algunos microservicios necesitan que otros ya estén corriendo para funcionar plenamente:

registro_usuario (puerto 8087) – porque gestiona los usuarios que necesita login_usuario.

login_usuario (puerto 8088) – depende de que existan usuarios en registro_usuario.

inventario (puerto 8082) – contiene los productos que usan otros microservicios.

El resto (sucursal, tiendaWeb, envio, proveedor, ventas, monitoreo) pueden arrancarse en cualquier orden.

Importante:

login_usuario requiere que previamente se haya registrado al menos un usuario en registro_usuario (a través de POST /api/v1/usuarios).

Si alguna entidad tiene como atributo otra entidad (por ejemplo, una reserva que contiene un cliente), deberás asegurarte de que esa entidad referenciada exista antes de crearla (no puedes guardar un objeto con relación a null a menos que el modelo lo permita explícitamente).

🔌 Puertos y rutas base de cada microservicio
La siguiente tabla muestra el puerto y las rutas base que debes usar para acceder a cada microservicio.
Todas las peticiones se construyen así:
http://localhost:{puerto}/{ruta_base}

Microservicio	Puerto	Rutas base (prefijo)
Monitoreo general	8089	/api/v1/monitoreo
Tienda Web	8085	/api/v1/carrito, /api/v1/estado_carrito, /api/v1/itemCarrito, /api/v1/orden, /api/v1/review
Envío	8086	/api/v1/envio, /api/v1/estado_envios, /api/v1/tipo_envio
Registro de usuarios	8087	/api/v1/tipoUsuario, /api/v1/usuarios
Login de usuarios	8088	/api/v1/login, /api/v1/EstadoSesion
Sucursal	8084	/api/v1/sucursales
Inventario	8082	/api/v1/libros
Proveedor	8091	/api/v1/proveedor, /api/v1/solicitudes
Ventas	8092	/api/v1/ventas, /api/v1/ordenes, /api/v1/medio_pago, /api/v1/estado_venta, /api/v1/estado_orden
Cómo usar las rutas
Cada ruta base puede tener operaciones CRUD adicionales (GET, POST, PUT, DELETE, etc.) y parámetros como /{id}.
Para conocer todas las rutas exactas (incluyendo las específicas como POST, PUT o DELETE), debes revisar dentro del código fuente de cada microservicio, en la carpeta controller. Allí encontrarás los métodos anotados con @GetMapping, @PostMapping, etc., junto con sus paths completos (a veces agregan sub-rutas como /{id} o /buscar).

Ejemplo concreto:

Para el microservicio de Envío, la tabla indica la ruta base /api/v1/envio.
Dentro de su EnvioController puede existir:
GET /api/v1/envio → listar todos
GET /api/v1/envio/{id} → obtener uno
POST /api/v1/envio → crear
PUT /api/v1/envio/{id} → actualizar
DELETE /api/v1/envio/{id} → eliminar
Esto debe ser verificado en el controller real.

Ejemplos de peticiones completas (asumiendo lo típico, pero confirma en el código):

GET http://localhost:8082/api/v1/libros (listar inventario)

POST http://localhost:8087/api/v1/usuarios (registrar usuario)

GET http://localhost:8088/api/v1/login?email=...&password=... (iniciar sesión, depende de la implementación)

🧪 Probar los endpoints con Postman
Una vez que todos los microservicios estén levantados, puedes usar Postman para probar las operaciones.

Crea una nueva colección para organizar las peticiones.

Para cada petición, selecciona el método HTTP (GET, POST, PUT, DELETE) y escribe la URL completa: http://localhost:puerto/ruta_base/....

Si el método requiere un cuerpo (body), selecciona raw → JSON y escribe el objeto correspondiente (los campos exactos dependen del DTO/modelo de cada microservicio).

Haz clic en Send y verifica el código de respuesta y los datos devueltos.

Nota importante:

Como los microservicios ya están programados, los nombres de los campos en los JSON se definen en los DTO y entidades. Para saber qué enviar en un POST o PUT, revisa la clase @RequestBody en el controller o los DTO del proyecto.

❗ Posibles problemas y soluciones
Problema	Solución
MySQL no arranca	Verifica que ningún otro servicio esté usando el puerto 3306. En XAMPP, prueba cambiar el puerto en my.ini.
Error “Table doesn't exist”	Asegúrate de que la propiedad spring.jpa.hibernate.ddl-auto=update está presente (los proyectos ya la tienen). Si no crea las tablas, créalas manualmente según las entidades.
El microservicio no termina de arrancar	Verifica que la base de datos correspondiente existe y que el nombre está bien escrito (respetando mayúsculas).
Al probar un POST, recibo 500 o violación de FK	Es probable que estés intentando crear un objeto que referencia otra entidad que aún no existe en su microservicio correspondiente. Crea primero los datos necesarios.
Login no funciona	Asegúrate de haber creado primero un usuario en registro_usuario (vía POST /api/v1/usuarios) antes de intentar loguearte.
No encuentro una ruta específica	Revisa el código fuente en la carpeta controller de cada microservicio. Puede que el profesor haya definido rutas personalizadas.
✅ Checklist para el profesor (o para cualquier persona que evalúe)
JDK 25 instalado correctamente.

XAMPP con MySQL iniciado (Apache opcional).

Se crearon todas las bases de datos con los nombres exactos (sin errores de tipeo).

Cada microservicio se ejecuta sin errores (se ve el mensaje "Started ..." en la consola).

Se puede acceder a cada microservicio desde Postman usando http://localhost:{puerto}/{ruta_base} al menos para un endpoint GET que devuelva algo (vacío o con datos).

Se comprueba que login_usuario funciona solo después de tener un usuario registrado.

Se entiende que para rutas más específicas (POST, PUT, DELETE, etc.) es necesario mirar dentro de cada controller.

📝 Notas finales importantes
No se debe modificar ningún archivo de configuración (como application.properties) a menos que el profesor lo indique explícitamente. Todo está preconfigurado para funcionar con MySQL local, usuario root y sin contraseña.

Las relaciones entre clases (por ejemplo, una Venta que tiene un Cliente) requieren que el objeto referenciado exista previamente en su respectivo microservicio. Si intentas guardar una venta con un idCliente que no está registrado en registro_usuario, la operación fallará.

El profesor debe revisar los controllers para conocer todas las rutas disponibles más allá de las rutas base listadas en este README. Cada método expuesto (POST, PUT, DELETE, GET con parámetros) está anotado con su path completo o relativo dentro de la ruta base.

Para una comunicación completa entre microservicios (por ejemplo, tiendaWeb consultando inventario), todos deben estar corriendo simultáneamente.
