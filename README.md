# Connect Health

Projeto de Conclusão do Curso Analise e Desenvolvimento de Sistemas. Neste projeto buscamos atender uma das 17 ODS, focando na Saúde e Bem-Estar.

## Objetivo

O objetivo deste projeto é armazenar em apenas um local todos os históricos médicos de uma pessoa/paciente, como exames, consultas, laudos, receitas médicas, etc.

### Pré-requisitos

Como preparar o seu ambiente.

Para executar o projeto em sua máquina, você precisa ter instalado as seguintes ferramentas:
* [Docker](https://www.docker.com/products/docker-desktop/)
* [DBeaver](https://dbeaver.io/download/)
* [Insomnia](https://insomnia.rest/download)

### Endpoints

#### Cadastro de Usuário

Para realizar o cadastro de um novo usuário, faça uma requisição POST para o seguinte endpoint:

`http://connect-health/auth/cadastrar`

##### Corpo da Requisição

Envie o seguinte JSON no corpo da requisição:

```json
{
  "nome": "Joao maria",
  "email": "JoaoMar1ia2@teste.com",
  "datanasc": "1998-02-20",
  "planosaude": "Unimed",
  "senha": "teste"
}
```
#### Exemplo de Resposta:
Uma resposta bem-sucedida retornará um JSON contendo um token de autenticação:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJsb2dpbi1hdXRoLWFwaSIsInN1YiI6IkpvYW9NYXIxaWEyQHRlc3RlLmNvbSIsImV4cCI6MTcxNjY2MTAzNn0.ZplPS4d6_WOvvibpnnsQgIbwI3KHEdIgYzFOrf3T74s"
}
```

#### Login de Usuário

Para realizar o login de um usuário, faça uma requisição POST para o seguinte endpoint:

`http://connect-health/auth/login`

##### Corpo da Requisição

Envie o seguinte JSON no corpo da requisição:

```json
{
  "email": "gustavojorge@teste.com",
  "senha": "teste"
}

