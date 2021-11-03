package co.usa.reto345.reto345.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto345.reto345.model.Message;
import co.usa.reto345.reto345.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){

        return messageRepository.getAll();

    }

    public Optional<Message> getMessage(int id){

        return messageRepository.getMessage(id);
    }

    public Message save(Message msg){

        if(msg.getIdMessage()==null){

            return messageRepository.save(msg);
        }

        else{

            Optional<Message> msgaux=messageRepository.getMessage(msg.getIdMessage());
            if(msgaux.isEmpty()){

                return messageRepository.save(msg);
            }
            else{

                return msg;
            }
        }


    }

    public Message update(Message msg){
        if(msg.getIdMessage()!=null){
            Optional<Message> msgaux= messageRepository.getMessage(msg.getIdMessage());
            if(!msgaux.isEmpty()){
                if(msg.getMessageText()!=null){
                    msgaux.get().setMessageText(msg.getMessageText());
                }
                messageRepository.save(msgaux.get());
                return msgaux.get();
            }else{
                return msg;
            }
        }else{
            return msg;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(msg -> {
            messageRepository.delete(msg);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
