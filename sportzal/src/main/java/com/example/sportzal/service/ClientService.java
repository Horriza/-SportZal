package com.example.sportzal.service;

import java.util.List;
import com.example.sportzal.model.Client;
public interface ClientService {
    void create(Client client);
    List<Client> readAll();
    Client read(int id);
    boolean update(Client client, int id);
    boolean delete(int id);
}
