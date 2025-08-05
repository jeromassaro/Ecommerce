package com.Ecommerce.services;

import com.Ecommerce.dtos.ClientUpdateDTO;
import com.Ecommerce.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<Client> getClients();
    Client getClientbyId(Long id);
    void deleteClient(Long id);
    Client updateClient(ClientUpdateDTO client, Long id);
    Client createClient(Client client);
}
