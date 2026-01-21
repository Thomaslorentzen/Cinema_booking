package dk.cbs.cinema_booking.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ReservationRequestDTO {

    @NotNull
    private Long performanceId;

    @NotNull
    @Min(1)
    private Integer numberOfSeats;

    public Long getPerformanceId() {
        return performanceId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }
}

