package dk.cbs.cinema_booking.dto;

public class ReservationResponseDTO {

    private final Long reservationID;

    public ReservationResponseDTO(Long reservationID) {
        this.reservationID = reservationID;
    }

    public Long getReservationId() {
        return reservationID;
    }
    
}
