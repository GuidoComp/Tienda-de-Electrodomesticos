# Tienda de Electrodomésticos - Microservicios

Este proyecto es el trabajo integrador final del curso **"Microservicios con Spring Cloud"** de TodoCode Academy. El objetivo es demostrar conocimientos prácticos y técnicos en el desarrollo de microservicios en Java utilizando Spring Cloud y otras herramientas, implementando patrones de diseño modernos.

## 📚 Objetivo

Crear un sistema compuesto por tres microservicios para gestionar diferentes aspectos de una tienda de electrodomésticos online. Los microservicios están diseñados para comunicarse entre sí y proporcionar una experiencia fluida a los usuarios.

## 🛠️ Microservicios

### 1. Microservicio de Productos
- **Funcionalidad**: Gestiona los electrodomésticos disponibles en la plataforma.
- **Operaciones**:
  - Listar productos.
  - Consultar detalles de un producto (código, nombre, marca, precio).
  - Crear, actualizar y eliminar productos.

### 2. Microservicio de Carrito de Compras
- **Funcionalidad**: Maneja los carritos de compras de los usuarios.
- **Operaciones**:
  - Agregar y quitar productos del carrito.
  - Consultar el contenido del carrito.
  - Calcular el precio total del carrito.

### 3. Microservicio de Ventas
- **Funcionalidad**: Registra las ventas realizadas en la plataforma.
- **Operaciones**:
  - Crear una venta asociada a un carrito de compras.
  - Consultar detalles de una venta (fecha, monto total, productos vendidos).

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot** (Spring Cloud, Eureka, Resilience4J)
- **Docker y Docker Compose**
- **MySQL** (base de datos)
- **API Gateway**
- **Herramientas de pruebas**: Postman
- **Sistema de control de versiones**: Git y GitHub

## 📋 Requerimientos Técnicos

### Arquitectura
Se utiliza una arquitectura de microservicios basada en Spring Cloud, con las siguientes características:
- **Eureka Server** para el registro y descubrimiento de servicios.
- **Spring Cloud Load Balancer** para balanceo de carga.
- **Resilience4J** para manejo de fallas (Circuit Breaker y Retry).
- **API Gateway** como punto de entrada para clientes externos.

### Docker
- Se incluyen Dockerfiles para cada microservicio.
- Un archivo `docker-compose.yml` permite el despliegue de todos los servicios.
- Los servicios están configurados para comunicarse correctamente en el entorno Docker.

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- Docker y Docker Compose instalados.
- JDK 17 instalado.
- Postman (opcional para pruebas).

### Instrucciones
1. Clona este repositorio:
```bash
   git clone https://github.com/GuidoComp/Tienda-de-Electrodomesticos
   cd tienda-electrodomesticos
```

2. Construye y levanta los contenedores:
```bash
docker-compose up --build
```
4. Accede a los microservicios a través de la API Gateway en http://localhost:8080.

5. Prueba los endpoints utilizando Postman o cualquier cliente HTTP.

🧪 Pruebas
1. Balanceo de carga:
  - Crea múltiples instancias del Microservicio de Productos y verifica con Postman que las solicitudes se distribuyan entre ellas.
2. Circuit Breaker:
  - Simula errores de comunicación y valida la ejecución del método fallback.
3. Docker:
  -  Asegúrate de que todos los servicios se comuniquen correctamente en el entorno Docker.
  
🎉 Bonus
  -  Repositorio Git: Este proyecto está gestionado local y remotamente con Git y GitHub.
  -  Servidor Centralizado de Configuraciones: Implementado utilizando Spring Cloud Config Server para gestionar configuraciones de los servicios.

📝 Autor
  -  Desarrollado por Guido como proyecto integrador final para el curso de TodoCode Academy.
```plaintext
📂 Estructura del Proyecto
tienda-electrodomesticos/
├── eureka-sv/
├── api-gateway/
├── products/
├── shopping-cart/
├── sales/
├── config-server/
├── config-data/
├── docker-compose.yml
└── README.md
```

📌 Notas
Este proyecto fue desarrollado como parte del curso, pero también está diseñado para formar parte de mi portafolio profesional. ¡Espero que sea de utilidad para futuros empleadores o colaboradores! 😄
