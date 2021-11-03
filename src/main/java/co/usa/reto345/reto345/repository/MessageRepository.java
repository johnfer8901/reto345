package co.usa.reto345.reto345.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.reto345.reto345.model.Message;
import co.usa.reto345.reto345.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){

        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){

        return messageCrudRepository.findById(id);

    }

    public Message save(Message msg){

        return messageCrudRepository.save(msg);
    }

    public void delete(Message msg){
        messageCrudRepository.delete(msg);
     }
    
}
