package com.example.sportzal.controller;

import com.example.sportzal.model.Abonement;
import com.example.sportzal.service.AbonementSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbonementContoller {
    private final AbonementSevice abonementSevice;

    @Autowired
    public AbonementContoller(AbonementSevice clientService) {
        this.abonementSevice = clientService;
    }

    @PostMapping(value = "/abonements")
    public ResponseEntity<?> create(@RequestBody Abonement abonement) {
        abonementSevice.create(abonement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/abonements")
    public ResponseEntity<List<Abonement>> read() {
        final List<Abonement> abonements = abonementSevice.readAll();

        return abonements != null &&  !abonements.isEmpty()
                ? new ResponseEntity<>(abonements, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/abonements/{id}")
    public ResponseEntity<Abonement> read(@PathVariable(name = "id") int id) {
        final Abonement abonement = abonementSevice.read(id);

        return abonement != null
                ? new ResponseEntity<>(abonement, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/abonements/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Abonement abonement) {
        final boolean updated = abonementSevice.update(abonement, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/abonements/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = abonementSevice.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
