package dk.cbs.cinema_booking.dto;

import java.time.LocalDateTime;

public class PerformanceResponseDTO {
    
    private final Long ID;
    private final String title;
    private final LocalDateTime showTime;
    private final int availableSeats;

    public PerformanceResponseDTO(Long ID, String title, LocalDateTime showTime, int availableSeats){
        this.ID = ID;
        this.title = title;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
    }

    public Long getId() { return ID; }
    public String getTitle() { return title; }
    public LocalDateTime getShowTime() { return showTime; }
    public int getAvailableSeats() { return availableSeats; }
    
}
