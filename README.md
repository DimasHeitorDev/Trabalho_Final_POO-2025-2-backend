# Backend do Sistema de Pedidos

Este é o backend do sistema de pedidos, desenvolvido com Spring Boot. Ele suporta armazenamento de imagens local e em nuvem (Cloudinary), além de banco de dados H2 (memória) e PostgreSQL.

## 🚀 Como Rodar

### Pré-requisitos
- Java 17+
- Maven

### Rodando Localmente
1.  Clone o repositório.
2.  Configure as variáveis de ambiente no arquivo `.env` (use `.env.example` como base) ou diretamente na sua IDE.
3.  Execute:
    ```bash
    ./mvnw spring-boot:run
    ```

## ☁️ Configuração de Nuvem (Render + Cloudinary)

Para rodar em produção, você deve configurar as seguintes **Variáveis de Ambiente**:

### Banco de Dados (PostgreSQL)
- `DB_URL`: URL de conexão JDBC (ex: `jdbc:postgresql://host:port/db`)
- `DB_USER`: Usuário do banco
- `DB_PASS`: Senha do banco

### Armazenamento de Imagens
Para usar o Cloudinary (ou outro serviço implementado):

- `IMAGE_STORAGE_TYPE`: Defina como `cloud`.
- `CLOUD_NAME`: Seu "Cloud Name" do Cloudinary.
- `CLOUD_API_KEY`: Sua "API Key".
- `CLOUD_API_SECRET`: Sua "API Secret".

> **Nota para Desenvolvedores:** A integração com Cloudinary está em `src/main/java/poo/services/ImagemServiceNuvem.java`. Você pode substituir a lógica deste arquivo para usar AWS S3, Google Cloud Storage, etc., mantendo a mesma interface.

## 📁 Estrutura
- `src/main/java/poo/services`: Contém a lógica de armazenamento (`ImagemServiceLocal` e `ImagemServiceNuvem`).
- `uploads/`: Diretório padrão para armazenamento local.

## 🔌 Endpoints da API

### Itens (`/item`)
- **Listar todos**: `GET /item`
    - **Resposta (Exemplo)**:
      ```json
      [
        {
          "id": 1,
          "name": "X-Bacon",
          "descricao": "Pão, carne, queijo e bacon",
          "preco": 25.0,
          "categoria": "LANCHE",
          "imageUrl": "https://..."
        }
      ]
      ```
- **Criar novo**: `POST /item`
    - **Body (Exemplo)**:
      ```json
      {
        "name": "Coca-Cola",
        "descricao": "Lata 350ml",
        "preco": 6.0,
        "categoria": "BEBIDA",
        "imageUrl": "https://..." // Opcional
      }
      ```
- **Buscar por ID**: `GET /item/{id}`
- **Deletar**: `DELETE /item/{id}`
- **Upload de Imagem**: `POST /item/upload` (Multipart File)

### Pedidos (`/pedidos`)
- **Criar Pedido**: `POST /pedidos`
    - **Body (Exemplo)**:
      ```json
      {
        "mesa": 10,
        "itens": {
          "1": 2,  // ID do Item : Quantidade
          "5": 1
        }
      }
      ```
- **Listar Pedidos**: `GET /pedidos`
    - **Resposta (Exemplo)**:
      ```json
      [
        {
          "id": 1,
          "mesa": 10,
          "data": "2023-11-29",
          "precoTotal": 56.0,
          "itens": [
            {
              "item": {
                "id": 1,
                "name": "X-Bacon",
                "preco": 25.0,
                ...
              },
              "quantidade": 2
            }
          ]
        }
      ]
      ```
- **Deletar Pedido**: `DELETE /pedidos?id={id}`

## ⚙️ Configurações Adicionais

### CORS
O projeto está configurado para aceitar requisições de **qualquer origem** (`*`). Isso facilita o desenvolvimento com frontends rodando em portas diferentes (ex: React em localhost:5173).

### Arquivos Estáticos
Imagens salvas localmente na pasta `uploads/` são servidas automaticamente na URL:
`http://localhost:8080/uploads/{nome_do_arquivo}`
