
# Weather API 🌦️

A lightweight RESTful API built with Spring Boot to fetch current weather data for any location. Designed with simplicity and efficiency in mind, this project demonstrates:

- Integration with external weather data providers (Visual Crossing)
- Caching for improved performance
- Integration tests using WireMock

## 🚀 Features
- Get today's weather by location
- Caching via Redis for faster responses
- Contract testing with WireMock
- Full Docker setup (Redis included)


## ⚙️ **Tech Stack**
![Java](https://img.shields.io/badge/Java-21-red?style=flat&logo=openjdk&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.3-6DB33F?style=flat&logo=springboot)  
![Docker](https://img.shields.io/badge/Docker-24.0.5-2496ED?style=flat&logo=docker)  
![Redis](https://img.shields.io/badge/Redis-7.2-DC382D?style=flat&logo=redis)  
![Feign](https://img.shields.io/badge/OpenFeign-✓-purple?style=flat)

## 🚀 Deploy
### Prerequisites
- [Java 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windowsl)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/products/docker-desktop/)

### Cloning
```bash
git clone https://github.com/GuilhermeLuan/Weather-API
```

### Starting

```bash
cd Weather-API
docker compose up
./mvnw clean install
./mvnw spring-boot:run
```
## 🌐 API Example

### GET /v1/weather/Brazil
```json
{
    "datetime": "2025-03-03",
    "address": "Brasil",
    "timezone": "America/Sao_Paulo",
    "description": "Similar temperatures continuing with no rain expected.",
    "temp": 23.4,
    "tempMax": 29.2,
    "tempMin": 20.0,
    "feelsLike": 23.3
}
```

# 📚 API Documentation

- [Doc](https://link-da-documentação)
