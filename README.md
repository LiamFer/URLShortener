# 🔗 URL Shortening Service

[roadmap.sh Project](https://roadmap.sh/projects/url-shortening-service)

Uma API RESTful para encurtar URLs longas, permitindo a criação, consulta, atualização, exclusão e visualização de estatísticas de acesso.

---

![URL Shortener Architecture](https://assets.roadmap.sh/guest/url-shortener-architecture-u72mu.png)

## 🚀 Funcionalidades

- 🔧 Criar uma URL encurtada
- 🔍 Recuperar a URL original a partir de um short code
- ♻️ Atualizar a URL original
- ❌ Deletar uma URL encurtada
- 📊 Consultar estatísticas de acesso

---

## 📫 Exemplo de uso da API

### ➕ Criar uma nova URL encurtada

```http
POST /shorten
Content-Type: application/json

{
  "url": "https://www.example.com/some/long/url"
}
````

📤 **Resposta**:

```json
{
  "id": "1",
  "url": "https://www.example.com/some/long/url",
  "shortCode": "abc123",
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z"
}
```

---

### 📥 Recuperar URL original

```http
GET /shorten/abc123
```

---

### 📝 Atualizar uma URL encurtada

```http
PUT /shorten/abc123
Content-Type: application/json

{
  "url": "https://www.example.com/some/updated/url"
}
```

---

### ❌ Deletar uma URL encurtada

```http
DELETE /shorten/abc123
```

---

### 📈 Obter estatísticas de acesso

```http
GET /shorten/abc123/stats
```

📤 **Resposta**:

```json
{
  "id": "1",
  "url": "https://www.example.com/some/long/url",
  "shortCode": "abc123",
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z",
  "accessCount": 10
}
```

---

## 🛠️ Tecnologias utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **Jakarta Validation**
* **H2 Database** (ou outro, configurável)
* **UUID para geração de short codes**
* **RESTful Controllers com tratamento global de erros**

---

## ⚙️ Tratamento de erros

A API retorna respostas amigáveis em caso de erro:

* `400 Bad Request` para erros de validação
* `404 Not Found` se o short code não existir
* `500 Internal Server Error` para exceções inesperadas

---

## 📁 Organização do Projeto

* `controller`: endpoints da API
* `service`: lógica de negócio
* `repository`: conexão com o banco
* `domain`: entidade `URLEntity`
* `DTO`: objetos de transferência e resposta
* `exceptions`: exceções customizadas
* `GlobalErrorHandler`: tratamento global de erros

---

## 💡 Melhorias futuras

* Autenticação e autorização
* Frontend simples com redirecionamento
* Cache para URLs mais acessadas
* Tempo de expiração para short codes (Pensei em fazer com Redis)

---

## 📎 Projeto original

Este projeto foi desenvolvido com base no desafio da comunidade:

🔗 [https://roadmap.sh/projects/url-shortening-service](https://roadmap.sh/projects/url-shortening-service)


