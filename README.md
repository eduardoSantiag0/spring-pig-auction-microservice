# **AuctionPigs Application**

AuctionPigs é um sistema de leilão de porcos desenvolvido com a **Arquitetura Clean** e projetado para microsserviços. A aplicação utiliza **RabbitMQ** para comunicação entre serviços, **PostgreSQL** para persistência de dados, e é containerizada com **Docker** para facilitar o deployment. A lógica de domínio segue padrões bem estabelecidos, garantindo escalabilidade, testabilidade e fácil manutenção.

## **Funcionalidades**

### **1. Leilões**

- Registro de novos leilões com informações do porco leiloado.
- Gerenciamento do status do leilão (aberto, finalizado).
- Expiração automática de leilões após a data definida.

### **2. Lances**

- Registro de lances durante o leilão (apenas na memória até o término do leilão).
- Validação de regras de negócio, como valor mínimo do lance e vinculação ao leilão.
- Persistência do maior lance ao término do leilão.

### **3. Comunicação Entre Microsserviços**

- Notificações de eventos importantes, como término do leilão e novo lance, via RabbitMQ.

### **4. API REST**

- Endpoints para gerenciar leilões e lances.

## **Estrutura do Projeto**

### **Camadas da Arquitetura Clean**

1. **Domain**: Contém entidades (`Auction`, `Pig`, `Bid`) e regras de negócio.
2. **Application**: Casos de uso, como `RegisterAuctionUseCase`  `RegisterBidUseCase` e `FinishAuctionUseCase`.
3. **Interface Adapters**: Controladores REST e adaptadores de mensageria.
4. **Frameworks & Drivers**: Repositórios, gateways para RabbitMQ e PostgreSQL.