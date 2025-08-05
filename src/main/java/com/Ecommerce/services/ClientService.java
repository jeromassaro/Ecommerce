package com.Ecommerce.services;

import com.Ecommerce.dtos.ClientUpdateDTO;
import com.Ecommerce.models.Client;
import com.Ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientbyId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(ClientUpdateDTO client, Long id) {
        Client oldClient = clientRepository.findById(id).orElse(null);
        if (oldClient != null) {
            oldClient.setAddress(client.getAddress());
            oldClient.setCity(client.getCity());
            return clientRepository.save(oldClient);
        }
        return null;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}
