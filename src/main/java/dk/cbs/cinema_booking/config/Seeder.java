package dk.cbs.cinema_booking.config;

import dk.cbs.cinema_booking.entity.Performance;
import dk.cbs.cinema_booking.repository.PerformanceRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class Seeder {
    
    @Bean
    CommandLineRunner seedPerformance(PerformanceRepository repository){
        return args -> {
            if ( repository.count() > 0){
                return;
            }

            List<Performance> performances = List.of(
                new Performance(
                            "Movie Night 1",
                            LocalDateTime.now().plusDays(1).withHour(18).withMinute(0)
                    ),
                    new Performance(
                            "Movie Night 2",
                            LocalDateTime.now().plusDays(1).withHour(21).withMinute(0)
                    ),
                    new Performance(
                            "Cinema Morning",
                            LocalDateTime.now().plusDays(2).withHour(10).withMinute(0)
                    ),
                    new Performance(
                            "Cinema Afternoon",
                            LocalDateTime.now().plusDays(2).withHour(14).withMinute(0)
                    ),
                    new Performance(
                            "Cinema Evening",
                            LocalDateTime.now().plusDays(2).withHour(19).withMinute(0)
                    )
            );
            repository.saveAll(performances);
        };
    }

}
