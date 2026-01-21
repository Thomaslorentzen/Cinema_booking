package dk.cbs.cinema_booking.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "performances")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime showTime;

    @OneToMany(
        mappedBy = "performance",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    private List<Reservations> reservations = new ArrayList<>();

    public static final int MAX_SEATS = 50;

    // Required by JPA
    protected Performance() {
    }

    // Domain constructor
    public Performance(String title, LocalDateTime showTime) {
        this.title = title;
        this.showTime = showTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public int getReservedSeats() {
        return reservations.stream()
                .mapToInt(Reservations::getNumberOfSeats)
                .sum();
    }

    public int getAvailableSeats() {
        return MAX_SEATS - getReservedSeats();
    }

    public void addReservation(Reservations reservation) {
        if (reservation.getNumberOfSeats() > getAvailableSeats()) {
            throw new IllegalStateException("Not enough available seats");
        }
        reservations.add(reservation);
        reservation.setPerformance(this);
    }

    public void removeReservation(Reservations reservation) {
        reservations.remove(reservation);
        reservation.setPerformance(null);
    }
}