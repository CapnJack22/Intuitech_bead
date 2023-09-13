package com.example.demo.clients.Service;

import com.example.demo.clients.Client;
import com.example.demo.clients.ClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //name max 100 karakter [y]
    //unique email [y]
    //valid email format [y]
    //responseban API kulcs UUID formatban []
    public void addNewClient(Client client) {

        int maxNameLength = 100;

        String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(client.getEmail());

        if(!matcher.matches()) {
            throw new IllegalArgumentException("invalid email format");
        }

        if(maxNameLength < client.getName().length()) {
            throw new IllegalArgumentException("name is too long");
        }
        Optional<Client> clientByEmail = clientRepository.findClientByEmail(client.getEmail());
        if(clientByEmail.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        clientRepository.save(client);
    }
}
