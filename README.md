# api_autos
spring boot + jpa + hibernate

Es un pequeño proyecto hecho con el fin de profundizar conocimientos

#consigna
obtener los datos se usuario provenientes del servicio soap(username, email)
y mostrarlos en el servicio rest(spring)

#nota
para configurar el servidor revisar src/resourses/aplication.properties

ya hay una coneccion a h2(bd enbebida en spring)

#ejemplo de conexion a mysql

spring.datasource.url=jdbc:mysql://localhost:3306/springdb1
spring.datasource.username=springuser
spring.datasource.password=f1e2l3i4x5
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
server.port=5000
