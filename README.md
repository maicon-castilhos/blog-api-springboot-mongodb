# Workshop Mongo API

Este é um projeto de API REST desenvolvida para a prática de integração entre **Spring Boot** e **MongoDB**. O sistema simula a gestão de um blog, onde usuários podem criar posts, comentar e realizar buscas avançadas.

## Tecnologias Utilizadas

- **Java 25**
- **Spring Boot** (WebMVC, Data MongoDB)
- **MongoDB** (Banco de dados NoSQL orientado a documentos)
- **Maven** (Gerenciador de dependências)

## Funcionalidades

### Usuários
- Listagem de todos os usuários cadastrados.
- Busca de usuário por ID.

### Posts
- Listagem de posts.
- Busca de posts por ID.
- Filtragem de posts por autor.
- Busca de posts por título (case-insensitive).
- **Busca Avançada (Filtro)**: Consulta complexa que permite buscar termos em qualquer lugar do post (título, corpo ou comentários) dentro de um intervalo de datas específico.

## Como Executar

1. **Pré-requisitos**:
   - JDK 25 instalado.
   - Uma instância do MongoDB rodando localmente ou via Atlas.
   - Maven instalado.

2. **Configuração**:
   - Configure as credenciais do seu banco de dados no arquivo `src/main/resources/application.properties`.

3. **Execução**:
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints Principais

### Usuários
- `GET /users` - Lista todos os usuários.
- `GET /users/{id}` - Detalhes de um usuário específico.

### Posts
- `GET /posts/{id}` - Detalhes de um post.
- `GET /posts/search?title=termo` - Busca posts pelo título.
- `GET /posts/filter?data=termo&fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd` - Busca avançada por texto e data.

## Estrutura do Projeto

- `domain`: Entidades do sistema (`User`, `Post`).
- `dto`: Objetos de transferência de dados para otimizar as respostas da API (`UserDTO`, `AuthorDTO`, `CommentDTO`).
- `repository`: Interfaces de acesso aos dados via Spring Data MongoDB.
- `services`: Camada de regra de negócio.
- `resources`: Controladores REST e tratamento de exceções.
- `config`: Classes de configuração e instanciamento de dados para teste.
- `util`: Classes utilitárias (como tratamento de URLs).

---

