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


### GET – Hent forestillinger
GET /performances

yaml
Kopier kode

Returnerer alle forestillinger samt antal ledige pladser.

---

### POST – Opret reservation
POST /reservations

css
Kopier kode

Eksempel på request body:
```json
{
  "performanceID": 1,
  "numberOfSeats": 3
}
DELETE – Aflys reservation
bash
Kopier kode
DELETE /reservations/{id}
API-dokumentation (OpenAPI 3)
OpenAPI-specifikationen er tilgængelig via:

bash
Kopier kode
/v3/api-docs
