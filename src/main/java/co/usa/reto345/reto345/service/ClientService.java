package co.usa.reto345.reto345.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto345.reto345.model.Client;
import co.usa.reto345.reto345.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){

        return clientRepository.getAll();

    }

    public Optional<Client> getClient(int id){

        return clientRepository.getClient(id);
    }

    public Client save(Client clt){

        if(clt.getIdClient()==null){

            return clientRepository.save(clt);
        }

        else{

            Optional<Client> cltaux=clientRepository.getClient(clt.getIdClient());
            if(cltaux.isEmpty()){

                return clientRepository.save(clt);
            }
            else{

                return clt;
            }
        }


    }

    public Client update(Client clt){
        if(clt.getIdClient()!=null){
            Optional<Client>cltaux=clientRepository.getClient(clt.getIdClient());
            if(!cltaux.isEmpty()){
                if(clt.getName()!=null){
                    cltaux.get().setName(clt.getName());
                }
                if(clt.getAge()!=null){
                    cltaux.get().setAge(clt.getAge());
                }
                if(clt.getPassword()!=null){
                    cltaux.get().setPassword(clt.getPassword());
                }
                clientRepository.save(cltaux.get());
                return cltaux.get();
            }else{
                return clt;
            }
        }else{
            return clt;
        }
    }
    public boolean deleteClient(int clientId) {
        Boolean cltaux=getClient(clientId).map(clt -> {
            clientRepository.delete(clt);
            return true;
        }).orElse(false);
        return cltaux;
    }
    
}
