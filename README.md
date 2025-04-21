
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)


# 🐷📈 **AuctionPigs Application**


**AuctionPigs** is a pig auction platform developed with **Spring Boot** and structured using **Clean Architecture**. The system follows a microservices approach and uses:
- 🐇 RabbitMQ for asynchronous communication between services
- 🐘 PostgreSQL for persistent data storage
- 🐳 Docker for containerized deployment
- 🛠 Flyway for version-controlled database migrations
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

- ``bid-ms`` sends bid data.
- ``auction-ms`` receives it via RabbitMQ, validates if it’s the highest, and updates accordingly. 📬

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

---

# Starting</h3>

### How to start:

```bash
cd spring-pig-auction-microservice
docker-compose up --built
```

## 📍 API Endpoints

## Auction Service (``auction-ms``)

| Method | Endpoint                                               | Description                 |
|--------|--------------------------------------------------------|-----------------------------|
| GET    | http://localhost:8082/auction-ms/auction/all           | List all active auctions   |
| POST   | http://localhost:8082/auction-ms/auction/create        | Create a new auction |

### GET ``/auction-ms/auction/all``

**RESPONSE**
```json
{
   "publicId": "04e719e9-09b5-4c6e-9eae-5b634050b1d6",
   "auctionedPig": {
      "name": "Bolinho",
      "weight": 220.3,
      "age": 3,
      "breed": "BERKSHIRE"
   },
   "highestBid": 1800,
   "startingPrice": 1200,
   "expirationDate": "2030-06-01",
   "isFinished": false,
   "highestBidderId": null
}
```

### POST ``/auction-ms/auction/create``

**REQUEST**
```json
{
   "auctionedPig": {
      "name": "Peppa Pig",
      "weight": 220.5,
      "age": 2,
      "breed": "HAMPSHIRE"
   },
   "startingPrice": 2500.00,
   "expirationDate": "2027-12-31"
}
```

## Bid Service (``bid-ms``)

| Method | Endpoint                                            | Description                     |
|--------|-----------------------------------------------------|---------------------------------|
| GET    | http://localhost:8082/bid-ms/bid/all                | List all bids                   |
| POST   | http://localhost:8082/bid-ms/bid/create             | Place a new bid                 |
| GET    | http://localhost:8082/bid-ms/bid/status/ {publicId} | Check bid result (success/fail) |


### POST ``bid/create``

**Request**
```json

{
   "auctionId": {random public id},   
   "value": 300
}
```

### GET ``/bid-ms/bid/all``

**RESPONSE**
```json
[   
  {
      "bidderId": "091b3e21-31b5-4530-83a0-4280b51d73d5",
      "auctionId": "04e719e9-09b5-4c6e-9eae-5b634050b1d6",
      "value": 4010,
      "timestamp": "2025-04-21T20:23:50.418149",
      "publicId": "1e67b43c-ac7d-4c3f-a2e3-69637ca3aedd",
      "success": true
   },
   {
      "bidderId": "f13447c9-f56d-45da-9860-1d932dfd91db",
      "auctionId": "04e719e9-09b5-4c6e-9eae-5b634050b1d6",
      "value": 3000,
      "timestamp": "2025-04-21T20:23:55.413117",
      "publicId": "27844cbe-fc7f-45b7-9c3f-6372255556b4",
      "success": false
   }
]
```

### GET ``/bid-ms/bid/status/{randomPublicID}``

**RESPONSE: Check the success property**
```json
{
   "bidderId": "f13447c9-f56d-45da-9860-1d932dfd91db",
   "auctionId": "04e719e9-09b5-4c6e-9eae-5b634050b1d6",
   "value": 4010,
   "timestamp": "2025-04-21T20:25:00.99156905",
   "publicId": "1e67b43c-ac7d-4c3f-a2e3-69637ca3aedd",
   "success": true
}
```