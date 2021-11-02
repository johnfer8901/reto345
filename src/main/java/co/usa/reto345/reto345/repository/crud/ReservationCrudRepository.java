package co.usa.reto345.reto345.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.usa.reto345.reto345.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}