# Cart Service
Grupo de microsserviços escritos com Java 11 que registram itens simples de compras. 

Requisições são feitas para o API gateway, que busca o token de autenticação no Okta. Caso o token não existe, a aplicação pede login. Tendo um token válido, é possível fazer requisições para os endepoints através do gateway, que redireciona as chamadas para o microsserviço cart-service, que, por sua vez, chama o microsserviço cart-service-pricing de forma assíncrona e exibe a resposta na tela uma vez que a promessa é cumprida.

## Tecnologias utilizadas
* Okta
* Project Lombok
* Netflix Hystrix
* Netflix Eureka
* Spring Boot
* Spring Cloud Gateway
* Spring Cloud Security
* Spring Cloud OpenFeign
* Spring Security
* Spring Actuator
* Spring Web
* Spring WebFlux
* Spring OAuth2
* Jackson DataType Money
* Logstash Logback