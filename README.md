![GitHub last commit](https://img.shields.io/github/last-commit/cironeto/json-mapping-bank-transactions?style=flat-square)
![GitHub top language](https://img.shields.io/github/languages/top/cironeto/json-mapping-bank-transactions?style=flat-square)

## Sobre
A aplicação faz o mapeamento de uma lista de 
transações bancárias contidas em arquivo json
para os campos descritos na [tabela](https://github.com/cironeto/json-mapping-bank-transactions#mapeamento).
O endpoint retorna as transações bancárias mapeadas
do usuário autenticado e retorna 403 para requisições
não autenticadas.


Funcionalidades:

    • Somente usuários autenticados podem acessar o endpoint.
    • Cada usário tem um accountId único e pode ver apenas suas transações.
    • Caso o usuário autenticado tentar acesar as transações de outro retorna Erro 403.


## Ferramentas utilizadas
- Java 11
- Spring Boot
- Spring Data JPA
- MySQL
- JWT/Auth0
- Docker


## Requisitos
Para execução deste projeto é necessário ter instalado:
- JDK 11
- Docker

## Execução
Execute via IDE ou abra o terminal em 
'.../json-mapping-bank-transactions' 
e execute o comando Docker para criar o servidor MySQL:
```sh
docker-compose up
```
Depois:
```sh
./mvnw clean install
```
Em seguida,execute a aplicação:

```sh
./mvnw spring-boot:run
```


Ao executar, a aplicação estará disponível 
em **http://localhost:8080** e será criado os seguintes usuários:

|   username   |   password|
|:------------:|:----------|
| william      | 123       |
| david        | 123       |
| cironeto     | 123       |

Endpoint de autenticação: **http://localhost:8080/login**


## REST API Endpoints
A requisição deve ser realizada no endpoint abaixo:


`GET /api/transactions/{accountId}`

## Mapeamento

|        Campos originais      	|             Campos a mapear          	|
|:----------------------------:	|:--------------------------------------------:	|
| encodedKey                   	| id                                           	|
| parentAccountKey             	| arrangementId                                	|
| creationDate                 	| bookingDate                                  	|
| type                         	| type                                         	|
| valueDate                    	| valueDate                                    	|
| amount                       	| amount                                       	|
| currencyCode                 	| currencyCode                                 	|
| currencyCode                 	| currency                                     	|
| amount                       	| creditDebitIndicator (DEBIT < 0, CREDIT >=0) 	|
| accountBalances.totalBalance 	| runningBalance                               	|
| id                           	| counterPartyAccountNumber                    	|
| parentAccountKey             	| reference                                    	|
| type                         	| typeGroup                                    	|
| amount                        | instructedAmount                              |

<br><br>
Desenvolvido por Ciro Neto
<div> 
<a href="https://api.whatsapp.com/send?phone=5519992582741" target="_blank"><img src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white" target="_blank"></a> 
<a href="https://www.linkedin.com/in/cironeto/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
<a href = "mailto:ciro.neto16@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
</div>



