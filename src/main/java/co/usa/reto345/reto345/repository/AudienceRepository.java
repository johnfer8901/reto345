package co.usa.reto345.reto345.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto345.reto345.model.Audience;
import co.usa.reto345.reto345.repository.crud.AudienceCrudRepository;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCrudRepository audienceCrudRepository;


    public List<Audience> getAll(){

        return (List<Audience>) audienceCrudRepository.findAll();
    }

    public Optional<Audience> getAudience(int id){

        return audienceCrudRepository.findById(id);

    }

    public Audience save(Audience audi){

        return audienceCrudRepository.save(audi);
    }
}  

