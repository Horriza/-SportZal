package com.example.sportzal.service;
import com.example.sportzal.model.Price;

import java.util.List;

public interface PriceService {

    void create(Price price);
    List<Price> readAll();
    Price read(int id);
    boolean update(Price price, int id);
    boolean delete(int id);
}
