# Cinema Booking – Backend Case

Dette projekt er udviklet som en del af en jobsamtalecase og demonstrerer grundlæggende færdigheder inden for Java, Spring Boot, REST API-design og relationelle databaser.

Applikationen udstiller et backend-API til håndtering af biografforestillinger og reservation af pladser uden nummererede sæder.

---

## Teknologi-stack

- **Java:** 21
- **Framework:** Spring Boot 3.4.1
- **Database:** PostgreSQL 17
- **ORM:** Spring Data JPA / Hibernate
- **API-dokumentation:** OpenAPI 3
- **Build tool:** Maven

---

## Funktionalitet

Systemet understøtter:
- 5 faste forestillinger (2 på én dag, 3 på en anden)
- Maksimalt 50 pladser pr. forestilling
- Reservation af én eller flere pladser
- Aflysning af reservationer
- Visning af ledige pladser pr. forestilling

Der findes **ingen GUI** – løsningen er udelukkende backend.

---

## Endpoints

Base URL: http://localhost:8080/cinema-booking/api/v1


## GET – Hent forestillinger
GET /performances



Returnerer alle forestillinger samt antal ledige pladser.

---

##POST – Opret reservation
POST /reservations

Eksempel på request body:
```json
{
  "performanceID": 1,
  "numberOfSeats": 3
}
```

##DELETE – Aflys reservation

DELETE /reservations/{id}
API-dokumentation (OpenAPI 3)

Database

Applikationen anvender PostgreSQL som relationel database.

Der er defineret følgende hovedentiteter:

**Performance** – repræsenterer en forestilling

**Reservation** – repræsenterer en reservation knyttet til en forestilling

Relationen er en én-til-mange-relation fra Performance til Reservation.

Databasen initialiseres ved opstart via en simpel seeder, som indsætter de faste forestillinger, hvis databasen er tom.

##Validering og fejlhåndtering
- Input valideres via Jakarta Bean Validation
- Forretningsfejl håndteres i service-laget
- API-fejl returneres i JSON-format

##Test af API
API'et er blevet testet ved brug af Postman app

Eksempel (GET):

GET http://localhost:8080/cinema-booking/api/v1/performances

Eksempel (POST):
POST http://localhost:8080/cinema-booking/api/v1/reservations
Content-Type: application/json

```json
{
  "performanceID": 1,
  "numberOfSeats": 2
}
```

##FOR AT KØRE PROJEKTET LOKALT

Forudsætninger:
- Java 21
- PostgreSQL skal køre lokalt
- Datavase oprettet

Fra terminal, kør applikationen ved:

mvn spring-boot:run 
