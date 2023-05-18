package com.example.sportzal.model;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="price")
public class Price {
    @Id
    @Column(name="numcard")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  num_card;
    @Column(name="clientsID")
    private Integer ID_client;
    @Column(name="abonementID")
    private Integer ID_abonementd;

    public Integer getId() {
        return num_card;
    }

    public void setId(Integer num_card) {
        this.num_card = num_card;
    }

    public Integer getID_Client() {
        return ID_client;
    }

    public void setID_Client(Integer ID_client) {
        this.ID_client = ID_client;
    }

    public Integer getID_Abonementd() {
        return ID_abonementd;
    }

    public void setID_Abonementd(Integer ID_abonementd) {
        this.ID_abonementd = ID_abonementd;
    }

    public List<Price> readAll() {
        return null;
    }

    public Price read(int id) {
        return null;
    }

    public boolean update(Price price, int id) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
