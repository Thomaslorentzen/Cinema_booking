package dk.cbs.cinema_booking.controller;

import dk.cbs.cinema_booking.dto.payload.SuccessPayload;
import dk.cbs.cinema_booking.dto.PerformanceResponseDTO;
import dk.cbs.cinema_booking.dto.ReservationRequestDTO;
import dk.cbs.cinema_booking.dto.ReservationResponseDTO;
import dk.cbs.cinema_booking.service.CinemaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


   
@RestController
@RequestMapping("/cinema-booking/api/v1")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }

    
    @GetMapping("/performances")
    public ResponseEntity<SuccessPayload<PerformanceResponseDTO>> getPerformances(){
        List <PerformanceResponseDTO> performances = cinemaService.getAllPerformances();

        SuccessPayload<PerformanceResponseDTO> payload =
                new SuccessPayload<>("Performance", performances);

        return ResponseEntity.ok(payload);


    }

    
    @PostMapping("/reservations")
    public ResponseEntity<Void> createReservation(
        @Valid @RequestBody ReservationRequestDTO request) {

    cinemaService.createReservation(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
   }
    
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {

        cinemaService.cancelReservation(id);

        return ResponseEntity.noContent().build();
    }
    
}
