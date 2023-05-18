package com.example.sportzal.service;
import com.example.sportzal.model.Price;
import com.example.sportzal.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServicelmpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void create(Price price) {
        priceRepository.save(price);
    }

    @Override
    public List<Price> readAll() {
        return priceRepository.findAll();
    }

    @Override
    public Price read(int id) {
        return priceRepository.getOne(id);
    }

    @Override
    public boolean update(Price price, int id) {
        if (priceRepository.existsById(id)) {
            price.setId(id);
            priceRepository.save(price);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (priceRepository.existsById(id)) {
            priceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
