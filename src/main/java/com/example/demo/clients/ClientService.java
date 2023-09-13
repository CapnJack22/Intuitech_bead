package com.example.demo.clients;

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

    private static final int MAX_NAME_LENGTH = 100;
    private static final String REGEX = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
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
    //responseban API kulcs UUID formatban [y]
    public String addNewClient(Client client) {


        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(client.getEmail());

        if(!matcher.matches()) {
            throw new IllegalArgumentException("invalid email format");
        }

        if(MAX_NAME_LENGTH < client.getName().length()) {
            throw new IllegalArgumentException("name is too long");
        }
        Optional<Client> clientByEmail = clientRepository.findClientByEmail(client.getEmail());
        if(clientByEmail.isPresent()){
            throw new IllegalStateException("email already taken");
        }

        clientRepository.save(client);

        return clientRepository.getIdByEmail(client.getEmail());
    }
}
