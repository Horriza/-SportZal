package com.example.sportzal.repository;
import com.example.sportzal.model.Abonement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface AbonementRepository extends JpaRepository<Abonement, Integer> {
}
