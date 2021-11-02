package co.usa.reto345.reto345.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto345.reto345.model.Reservation;
import co.usa.reto345.reto345.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){

        return reservationCrudRepository.findById(id);

    }

    public Reservation save(Reservation resv){

        return reservationCrudRepository.save(resv);
    }
    
}
