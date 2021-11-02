package co.usa.reto345.reto345.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.usa.reto345.reto345.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
