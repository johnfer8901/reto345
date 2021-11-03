package co.usa.reto345.reto345.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.reto345.reto345.model.Audience;
import co.usa.reto345.reto345.repository.AudienceRepository;


@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){

        return audienceRepository.getAll();

    }

    public Optional<Audience> getAudience(int id){

        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audi){

        if(audi.getId()==null){

            return audienceRepository.save(audi);
        }

        else{

            Optional<Audience> audiaux=audienceRepository.getAudience(audi.getId());
            if(audiaux.isEmpty()){

                return audienceRepository.save(audi);
            }
            else{

                return audi;
            }
        }


    }

    public Audience update(Audience audi){
        if(audi.getId()!=null){
            Optional<Audience> audiaux=audienceRepository.getAudience(audi.getId());
            if(!audiaux.isEmpty()){
                if(audi.getName()!=null){
                    audiaux.get().setName(audi.getName());
                }
                if(audi.getOwner()!=null){
                    audiaux.get().setOwner(audi.getOwner());
                }
                if(audi.getCapacity()!=null){
                    audiaux.get().setCapacity(audi.getCapacity());
                }
                if(audi.getDescription()!=null){
                    audiaux.get().setDescription(audi.getDescription());
                }
                if(audi.getCategory()!=null){
                    audiaux.get().setCategory(audi.getCategory());
                }
                audienceRepository.save(audiaux.get());
                return audiaux.get();
            }else{
                return audi;
            }
        }else{
            return audi;
        }
    }

    public boolean deleteAudience(int audienceId) {
        Boolean aBoolean = getAudience(audienceId).map(audi -> {
            audienceRepository.delete(audi);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
}
