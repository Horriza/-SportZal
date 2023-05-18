package com.example.sportzal.service;
import com.example.sportzal.model.Abonement;

import java.util.List;

public interface AbonementSevice {
    void create(Abonement abonement);
    List<Abonement> readAll();
    Abonement read(int id);
    boolean update(Abonement abonement, int id);
    boolean delete(int id);
}
