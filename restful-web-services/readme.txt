NEW URL for SWAGGER UI - http://localhost:8080/swagger-ui/ or http://localhost:8080/swagger-ui/index.html
Example pom.xml with the changes here - https://github.com/in28minutes/spring-microservices/blob/master/02.restful-web-services/2.3.1.RELEASE-upgrade.md#pomxml

Example SwaggerConfig with the changes here - https://github.com/in28minutes/spring-microservices/blob/master/02.restful-web-services/2.3.1.RELEASE-upgrade.md#srcmainjavacomin28minutesrestwebservicesrestfulwebservicesswaggerconfigjava


Add these dependencies to pom.xml instead of the two swagger dependencies.

    <dependency>
    	<groupId>io.springfox</groupId>
    	<artifactId>springfox-boot-starter</artifactId>
    	<version>3.0.0</version>
    </dependency>

http://localhost:8080/actuator

https://github.com/in28minutes/spring-microservices

http://localhost:8080/h2-console
verify that JDBC URL has value jdbc:h2:mem:testdb


