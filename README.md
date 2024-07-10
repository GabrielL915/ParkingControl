# Parking Control API

# API de Controle de Estacionamento

A API de Controle de Estacionamento fornece endpoints para gerenciar veículos, apartamentos e proprietários em um sistema de controle de estacionamento.

### Informações

Para informações mais detalhadas sobre os esquemas de requisição/resposta e comportamentos específicos dos endpoints, por favor, consulte a especificação OpenAPI completa.

---

## Endpoints da API

### Vehicles

- `POST /vehicles`: Criar um novo veículo
- `GET /vehicles`: Listar todos os veículos
- `GET /vehicles/{id}`: Obter veículo por ID
- `PUT /vehicles/{id}`: Atualizar um veículo
- `DELETE /vehicles/{id}`: Excluir um veículo

### Apartments

- `POST /apartments`: Criar um novo apartamento
- `GET /apartments`: Listar todos os apartamentos
- `GET /apartments/{id}`: Obter apartamento por ID
- `PUT /apartments/{id}`: Atualizar um apartamento
- `DELETE /apartments/{id}`: Excluir um apartamento

### Owner

- `POST /owners`: Criar um novo proprietário
- `GET /owners`: Listar todos os proprietários
- `GET /owners/{id}`: Obter proprietário por ID
- `PUT /owners/{id}`: Atualizar um proprietário
- `DELETE /owners/{id}`: Excluir um proprietário
