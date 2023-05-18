package com.example.sportzal.controller;

import com.example.sportzal.model.Price;
import com.example.sportzal.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping(value = "/prices")
    public ResponseEntity<?> create(@RequestBody Price price) {
        priceService.create(price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<List<Price>> read() {
        final List<Price> prices = priceService.readAll();

        return prices != null &&  !prices.isEmpty()
                ? new ResponseEntity<>(prices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/prices/{num_card}")
    public ResponseEntity<Price> read(@PathVariable(name = "num_card") int num_card) {
        final Price price = priceService.read(num_card);

        return price != null
                ? new ResponseEntity<>(price, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/prices/{num_card}")
    public ResponseEntity<?> update(@PathVariable(name = "num_card") int num_card, @RequestBody Price price) {
        final boolean updated = priceService.update(price, num_card);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/prices/{num_card}")
    public ResponseEntity<?> delete(@PathVariable(name = "num_card") int num_card) {
        final boolean deleted = priceService.delete(num_card);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
