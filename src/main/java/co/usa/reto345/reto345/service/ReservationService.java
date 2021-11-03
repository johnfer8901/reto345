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

    public Reservation save(Reservation resv){

        if(resv.getIdReservation()==null){

            return reservationRepository.save(resv);
        }

        else{

            Optional<Reservation> resvaux=reservationRepository.getReservation(resv.getIdReservation());
            if(resvaux.isEmpty()){

                return reservationRepository.save(resv);
            }
            else{

                return resv;
            }
        }


    }

    public Reservation update(Reservation resv){
        if(resv.getIdReservation()!=null){
            Optional<Reservation> resvaux= reservationRepository.getReservation(resv.getIdReservation());
            if(!resvaux.isEmpty()){

                if(resv.getStartDate()!=null){
                    resvaux.get().setStartDate(resv.getStartDate());
                }
                if(resv.getDevolutionDate()!=null){
                    resvaux.get().setDevolutionDate(resv.getDevolutionDate());
                }
                if(resv.getStatus()!=null){
                    resvaux.get().setStatus(resv.getStatus());
                }
                reservationRepository.save(resvaux.get());
                return resvaux.get();
            }else{
                return resv;
            }
        }else{
            return resv;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(resv -> {
            reservationRepository.delete(resv);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
