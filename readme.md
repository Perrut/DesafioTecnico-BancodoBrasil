# Desafio BB

Este projeto é uma solução ao desafio proposto enviado por email para consulta de dados na API do Banco Mundial sobre índice que avalia a quantidade de pessoas em situação de extrema pobreza no mundo, vivendo com até $ 1,90/dia (dólar).

## Construindo o projeto

### Frontend

Basta possuir o Docker instalado na máquina.

### Backend

É necessário possuir localmente o Maven versão 3.6.3 ou superior e o Java na versão 11.
Na pasta backend, executar o comando para gerar o artefato do projeto:
- `mvnw clean package`

### Frontend e backend juntos (geração de imagens)

Executar o comando:
- `docker-compose build` na pasta raíz do projeto para montar as imagens

## Executando a aplicação

- Executar o comando `docker-compose up` na pasta raíz do projeto para subir a aplicações
- A aplicação frontend estará disponível no seguinte endereço: http://localhost:4200
  - A aplicação é constituída de um formulário, onde o usuário deve inserir o código de um país para obter os dados necessários
    - Exemplo de código de país: BRA para Brasil
    - Mais códigos estão disponíveis no endereço: https://api.worldbank.org/v2/country?format=json
- A aplicação do backend possui uma documentação OpenAPI, disponível no browser pelo endereço http://localhost:8080/q/swagger-ui

## Executando testes da aplicação

### Backend

- Para executar os testes do backend, basta executar o comando `mvnw clean verify` na pasta backend

### Frontend

- Para executar os testes do frontend, é necessário executar o comando `npm install` na pasta frontend primeiro para instalar as dependências, pois o frontend é todo construído no Docker
  - A versão do Node utilizada no projeto foi a 10, será necessário essa versão na máquina para execução dos testes
  - Após isso, é necessário executar o comando `npm run test` na pasta frontend (caso o comando falhar, instale o Angular CLI através do comando `npm i -g @angular/cli@v9-lts`, e tente novamente com o comando `ng test` na pasta frontend)
