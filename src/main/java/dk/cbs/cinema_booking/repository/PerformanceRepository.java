package dk.cbs.cinema_booking.repository;

import dk.cbs.cinema_booking.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}