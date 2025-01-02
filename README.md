# Agencia de Viajes

 ## API REST Hotel-Vuelo-Reserva
 
Este repositorio contiene tres microservicios desarrollados en Spring Boot para gestionar reservas. La aplicación utiliza una base de datos H2 de la que se adjuntan los scripts en el repositorio para realizar los INSERT necesarios en hoteles y vuelos. Expone sus funcionalidades a través de una API REST que se muestran a través del navegador.

### Características Principales
-	Arquitectura basada en microservicios.
-	Uso base de datos H2.
-	Relaciona los microservicios hotel y vuelo con el microservicio reserva.
-	Exposición de endpoints para interactuar con todas las entidades.

### Tecnologías Utilizadas
-	**Spring Boot**: Infraestructura para microservicios eficiente.
-	**Swagger**: Documentación y visualización de API RESTful.
-	**Junit**: Marco para pruebas unitarias en Java.

### Inicio Rápido
1.	**Clonar el repositorio**: git clone https://github.com/silviaglezz/AgenciaViajes.git
2.	**Acceder al directorio del proyecto**: cd AgenciaViajes

### Entidades
1.	**Hotel**: Representa a un hotel con las propiedades id del hotel, nombre, categoría, precio y disponibilidad.
2.	**Vuelo**: Representa un vuelo con las propiedades id del vuelo, compañía, fecha del vuelo, precio y plazas disponibles.
3.	**Reserva**: Representa una reserva con las propiedades id de la reserva, nombre del cliente, dni, id del hotel, id del vuelo y total de personas.

## Servicio Hotel
Este microservicio proporciona funcionalidades para la gestión de hoteles.

### Funcionalidades
1.	Listar todos los hoteles que estén disponibles.
2.	Listar todos los hoteles por un nombre.
3.	Obtener un hotel por su nombre.

### Endpoints
**Puerto 8080**
1.	**Listar todos los hoteles**
    -	**URL**: /hoteles
    -	**Método**: GET
2.	**Listar todos los hoteles por un nombre**
    -	**URL**: /hoteles/{nombre}
    -	**Método**: GET
3.	**Obtener un hotel por su nombre**
    -	**URL**: /hoteles/nombre/{nombre}
    -	**Método**: GET

## Servicio Vuelo
Este microservicio proporciona funcionalidades para la gestión de vuelos

### Funcionalidades
1.	Listar todos los vuelos que estén disponibles para un número de plazas determinado.
2.	Actualizar las plazas disponibles de un vuelo.
3.	Obtener un vuelo por su id.

### Endpoints
**Puerto 9000**
1.	**Listar todos los vuelos que estén disponibles para un número de plazas determinado**
    -	**URL**: /vuelos/{plazasReserva}
    -	**Método**: GET
2.	**Actualizar las plazas disponibles de un vuelo**
    -	**URL**: /vuelos/{idVuelo}/{plazasReservadas}
    -	**Método**: PUT
3.	**Obtener un vuelo por su id**
    -	**URL**: /vuelos/vuelo/{id}
    -	**Método**: GET

## Servicio Reserva
Este interaccionará con el servicio de hoteles y de vuelos para ofrecer su funcionalidad. Los datos que caracterizan una reserva serán:
-	idReserva (numérico entero)
-	nombreCliente (texto)
-	dni(texto)
-	idHotel (numérico entero)
-	idVuelo (numérico entero)
-	totalPersonas (numérico entero)

### Funcionalidades
-	Expone un recurso que ante una petición de tipo post, que recibe en el cuerpo de la misma un objeto JSON con el identificador vuelo, identificador hotel, nombre, dni y total de personas que forman la reserva, registrará la misma en la base de datos. Interacciona con el servicio de vuelos para actualizar las plazas disponibles al realizar la reserva.
-	Dispondrá de otro recurso que, ante una petición get, devolverá las reservas existentes (nombre, dni, vuelo), para el nombre hotel recibido como variable en url. Deberá interaccionar con el servicio de hoteles para conocer el idHotel a partir de su nombre.

### Endpoints
**Puerto 7000**
1.	**Registrar reserva**
    -	**URL**: /reservas
    -	**Método**: POST
2.	**Listar las reservas por el nombre del hotel**
    -	**URL**: /reservas/{nombreHotel}
    -	**Método**: GET
