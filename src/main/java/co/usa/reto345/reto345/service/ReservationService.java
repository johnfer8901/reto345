package co.usa.reto345.reto345.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto345.reto345.model.Reservation;
import co.usa.reto345.reto345.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){

        return reservationRepository.getAll();

    }

    public Optional<Reservation> getReservation(int id){

        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation clt){

        if(clt.getIdReservation()==null){

            return reservationRepository.save(clt);
        }

        else{

            Optional<Reservation> cltaux=reservationRepository.getReservation(clt.getIdReservation());
            if(cltaux.isEmpty()){

                return reservationRepository.save(clt);
            }
            else{

                return clt;
            }
        }


    }
    
}
