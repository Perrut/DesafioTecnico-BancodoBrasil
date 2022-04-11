# Histórias

## História 1: Criação da API backend

Como usuário/desenvolvedor, necessito de uma API que consulte os dados do banco mundial de pobreza,
para que eu consiga desenvolver uma aplicação cliente para consumo e visualização desses dados.

Critérios de aceite
- AC1 - Devo conseguir acessar a API e conumir seu conteúdo via JSON

Testes:
- API deve retornar dados do país correto ao se digitar uma sigla, exemplo:
Ao digitar BRA, devem ser retornados dados do Brasil

## História 2: Criação da aplicação cliente frontend

Como usuário do sistema de visualização, necessito de uma interface gráfica web,
para que eu não necessite de conhecimentos avançados para visualizar os dados oriundos da API

Critérios de aceite
- AC1 - Deve ser possível visualizar os indicadores por país

Testes:
- Ao digitar um código válido, devem ser retornados os dados para visualização em grid
- Ao digitar um código inválido, deve ser exibida mensagem avisando sobre o erro

## História 3: Dockerização do ambiente

Como desenvolvedor responsável pela manutenção do sistema, necessito que o a aplicação possa
ser executada em ambiente Docker, para que eu consiga facilmente executá-la em qualquer ambiente e realizar a portabilidade da mesma
para qualquer ambiente de implantação.

Critérios de aceite
- AC1 - Deve ser possível executar a aplicação com Docker

Testes:
- Verificar se com o comando docker-compose up, a aplicação fica de pé e é possível utiizar a mesma