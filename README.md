# 🐷📈 **AuctionPigs Application**

**AuctionPigs** is a pig auction system built using **Clean Architecture** and designed with a **microservices** approach. The application uses **🐇 RabbitMQ** for inter-service communication, **🐘 PostgreSQL** for data persistence, and is containerized with **🐳 Docker** to streamline deployment.

---

## 🚀 **Features**

### 🐖 1. **Auctions**

- Create new auctions with pig details.
- Automatically expire auctions after the scheduled end date. ⏳

### 💰 2. **Bids**

- Place bids during active auctions.
- Validates business rules such as minimum bid amount and auction linkage.
- Saves the highest bid when the auction ends. 🏆

### 🔁 3. **Microservice Communication**

- Important event notifications (e.g., auction ended, new bid placed) sent via RabbitMQ. 📬

### 🌐 4. **REST API**

- Endpoints for managing auctions and bids using HTTP methods. 🔧

---

## 🧱 **Project Structure**

### 🧭 **Clean Architecture Layers**

1. **Domain**
    - Contains core entities: `Auction`, `Pig`, `Bid`
    - Business rules live here 📐

2. **Application**
    - Use cases like `RegisterAuctionUseCase`, `RegisterBidUseCase`, and `FinishAuctionUseCase` 🚦

3. **Interface Adapters**
    - REST controllers and messaging adapters 🔌

4. **Frameworks & Drivers**
    - Repositories, RabbitMQ and PostgreSQL gateways 🛤️

                   +----------------------------+
                   |     🚪 External Interfaces   |
                   |  (REST Controllers, MQ Adapters)  |
                   +----------------------------+
                              |
                              v
                   +----------------------------+
                   |  🔄 Interface Adapters       |
                   |  (HTTP, RabbitMQ, DTOs)      |
                   +----------------------------+
                              |
                              v
                   +----------------------------+
                   |   ⚙️ Application Layer        |
                   |  Use Cases:                 |
                   |  - RegisterAuction          |
                   |  - RegisterBid              |
                   |  - FinishAuction            |
                   +----------------------------+
                              |
                              v
                   +----------------------------+
                   |   🧠 Domain Layer             |
                   |  Entities:                  |
                   |  - Auction                  |
                   |  - Pig                      |
                   |  - Bid                      |
                   |  Business Rules             |
                   +----------------------------+
                              ^
                              |
                   +----------------------------+
                   |   🧰 Frameworks & Drivers     |
                   |  - PostgreSQL Repository     |
                   |  - RabbitMQ Gateway          |
                   |  - Docker                    |
                   +----------------------------+

---
