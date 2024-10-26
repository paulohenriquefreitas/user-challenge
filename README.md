# README #


### Como rodar a aplicação ###

* Clone o repository:  https://github.com/paulohenriquefreitas/user-challenge.git or git@github.com:paulohenriquefreitas/user-challenge.git
* Build : ./gradlew clean build
* Rode a application com gradle command: ./gradlew clean build bootRun


### Os recursos  ###
Ler o arquivo e salvar os dados em banco de memoria h2
curl --location 'localhost:8080/users/' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=59C26EE1A49254FAB91AAB743F21C96B' \
--form 'file=@"<path-file>/data_1.txt"'

Ler todos os usuários
curl --location 'localhost:8080/users/' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=59C26EE1A49254FAB91AAB743F21C96B'

Buscar uma ordem por id
curl --location 'localhost:8080/orders/5' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=59C26EE1A49254FAB91AAB743F21C96B'

Buscar uma lista de ordens por um intervalo de tempo.
curl --location 'localhost:8080/orders/date-range?startDate=2020-01-01&endDate=2023-12-31' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=59C26EE1A49254FAB91AAB743F21C96B'

A Postman collection está na raíz da aplicação.

Banco de dados
Cada vez que a aplicação subir, um banco de dados h2 será criado em memória.
Url para acessar o banco: http://localhost:8080/h2-console
user: sa
password: sa




### Conclusão  ###

Foi usada a linguagem Java, como framework SpringBoot por ser uma linguagem robusta e de fácil implementação.
Eu poderia ter usado NodJs por ser uma liguagem que me sinto confortável também. 
Na arquitetura de uma aplicação Spring Boot, é comum seguir um padrão de camadas para separar as responsabilidades entre Controller (Controlador), 
Service (Serviço), Repository (Repositório) e Model (Modelo ou Entidade). 
Esse padrão facilita o desenvolvimento, a manutenção e a escalabilidade da aplicação, promovendo uma clara separação de responsabilidades.
Existem outras tecnologias que eu teria usado. 
Para alto volume de dados, NOSQL seria melhor, porque é mais escalável. Eu teria usado Mongo para persistência.
Muitos outros testes poderiam ter sido implementado em um ambiente real de desenvolvimento.Para essa demonstração
implementei apenas um como exaemplo.
