
# Projeto API Spring - Fórum Hub

<div align="center">
    <img width="30%" src="assets/badge_spring.png" alt="Insígnia da conclusão do Challenge">
</div>

Este é um projeto de uma API REST desenvolvida com Spring Boot, que oferece funcionalidades para gerenciar usuários, tópicos, respostas para esses tópicos e cursos, utilizando autenticação baseada em JWT.

## Ferramentas Utilizadas

<div align="left">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=spring,java,maven,mysql&perline=9" />
  </a>
</div>

## Funcionalidades

- **Autenticação**: Login e gerenciamento de tokens JWT.
- **Usuários**: Cadastro e listagem de usuários.
- **Tópicos**: Criação, atualização e listagem de tópicos.
- **Respostas**: Registro de respostas para tópicos.
- **Cursos**: Cadastro e listagem de cursos.

## Endpoints e Exemplos

### Autenticação

#### `POST /login`
- **Descrição**: Realiza o login e retorna o token JWT.
- **Exemplo de Request**:

```json
{
  "username": "usuario@dominio.com",
  "password": "senha"
}
```

- **Exemplo de Response**:

```json
{
  "Token": "seu-token-jwt-aqui"
}
```

---

### Usuários

#### `POST /usuarios`
- **Descrição**: Registra um novo usuário.
- **Exemplo de Request**:

```json
{
  "name": "Nome do Usuário",
  "email": "usuario@dominio.com",
  "password": "senha"
}
```

- **Exemplo de Response**:

```json
{
  "id": 1,
  "name": "Nome do Usuário",
  "email": "usuario@dominio.com"
}
```

---

#### `GET /usuarios`
- **Descrição**: Lista os usuários cadastrados.
- **Exemplo de Response**:

```json
[
  {
    "id": 1,
    "name": "Nome do Usuário",
    "email": "usuario@dominio.com"
  }
]
```

---

### Tópicos

#### `POST /topics`
- **Descrição**: Cria um novo tópico.
- **Exemplo de Request**:

```json
{
  "title": "Título do Tópico",
  "message": "Mensagem do Tópico",
  "authorId": 1,
  "courseId": 1
}
```

- **Exemplo de Response**:

```json
{
  "id": 1,
  "title": "Título do Tópico",
  "message": "Mensagem do Tópico",
  "creationDate": "2025-01-21T00:00:00Z",
  "status": "NOT_ANSWERED",
  "authorName": "Nome do Autor",
  "courseName": "Nome do Curso"
}
```

---

#### `GET /topics`
- **Descrição**: Lista todos os tópicos.
- **Exemplo de Response**:

```json
[
  {
    "id": 1,
    "title": "Título do Tópico",
    "message": "Mensagem do Tópico",
    "creationDate": "2025-01-21T00:00:00Z",
    "status": "NOT_ANSWERED",
    "authorName": "Nome do Autor",
    "courseName": "Nome do Curso"
  }
]
```

---

### Respostas

#### `POST /responses`
- **Descrição**: Cria uma nova resposta para um tópico.
- **Exemplo de Request**:

```json
{
  "message": "Resposta ao tópico",
  "authorId": 1,
  "topicId": 1,
  "solution": false
}
```

- **Exemplo de Response**:

```json
{
  "id": 1,
  "message": "Resposta ao tópico",
  "authorName": "Nome do Autor",
  "topicId": 1
}
```

---

### Cursos

#### `POST /courses`
- **Descrição**: Cria um novo curso.
- **Exemplo de Request**:

```json
{
  "name": "Nome do Curso",
  "category": "BACK_END"
}
```

- **Exemplo de Response**:

```json
{
  "id": 1,
  "name": "Nome do Curso",
  "category": "BACK_END"
}
```

---

#### `GET /courses`
- **Descrição**: Lista todos os cursos.
- **Exemplo de Response**:

```json
[
  {
    "id": 1,
    "name": "Nome do Curso",
    "category": "BACK_END"
  }
]
```

---

## Documentação da API

A documentação da API está disponível através do Swagger. Para acessá-la, inicie o servidor e acesse o seguinte endpoint:

- **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

A documentação interativa gerada pelo SpringDoc permite visualizar todos os endpoints e realizar requisições diretamente pela interface.

## Como Executar o Projeto

1. Clone este repositório.
2. Abra o projeto em sua IDE preferida.
3. Certifique-se de ter o **Java 21** e o **Maven** instalados.
4. Execute o comando para iniciar o servidor:

```bash
mvn spring-boot:run
```

5. O servidor será iniciado em `http://localhost:8080`.

## Dependências

- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
