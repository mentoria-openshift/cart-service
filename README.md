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

## Como usar
Basta subir o servidor Eureka antes de tudo, e depois subir os demais serviços. Todos se conectam ao Eureka e se registram como clientes, e um serviço encontra o outro automaticamente por balancers.

### Endpoints
Não se deve acessar diretamente os microsserviços, e sim o gateway. 
* O endpoint `/cart/{id}` por `GET` lista o carrinho daquele id. 
* O endpoint `/cart` por `POST` com o payload no formato do modelo de domínio insere um novo carrinho.
* O endpoint `/carts` por `GET` lista todos os carrinhos cadastrados.

### Variáveis de ambiente
É necessário ter uma conta no Okta com uma aplicação criada, e definir em variáveis de ambiente o client secret, client id e issuer da sua aplicação do Okta. 
* `OKTA_OAUTH2_ISSUER`: URL do issuer da aplicação do Okta
* `OKTA_OAUTH2_CLIENT_ID`: Client ID da aplicação do Okta
* `OKTA_OAUTH2_CLIENT_SECRET`: Client secret da aplicação do Okta

Também é necessária uma segunda aplicação definida como serviço no Okta para servir como base entre os microsserviços, atuando como servidor de recursos.
* `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_PRICINGCLIENT_CLIENTID`: Client ID da aplicação de serviço do Okta
* `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_PRICINGCLIENT_CLIENTSECRET`: Client secret da aplicação de serviço do Okta
