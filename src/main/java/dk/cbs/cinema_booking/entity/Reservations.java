package dk.cbs.cinema_booking.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservations")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    private int numberOfSeats;

    private LocalDateTime createdAt;

    public Reservations() {
        this.createdAt = LocalDateTime.now();
    }

    public Reservations(Performance performance, int numberOfSeats) {
        this.performance = performance;
        this.numberOfSeats = numberOfSeats;
        this.createdAt = LocalDateTime.now();
    }

    // ----- Getters og Setters til koden -----
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Performance getPerformance() { return performance; }
    public void setPerformance(Performance performance) { this.performance = performance; }

    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
