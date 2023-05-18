package com.example.sportzal.service;
import com.example.sportzal.model.Abonement;
import com.example.sportzal.repository.AbonementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonementSevicelmpl implements AbonementSevice{
    @Autowired
    private AbonementRepository abonementRepository;

    @Override
    public void create(Abonement abonement) {
        abonementRepository.save(abonement);
    }

    @Override
    public List<Abonement>  readAll() {
        return abonementRepository.findAll();
    }

    @Override
    public Abonement read(int id) {
        return abonementRepository.getOne(id);
    }

    @Override
    public boolean update(Abonement abonement, int id) {
        if (abonementRepository.existsById(id)) {
            abonement.setId(id);
            abonementRepository.save(abonement);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (abonementRepository.existsById(id)) {
            abonementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
