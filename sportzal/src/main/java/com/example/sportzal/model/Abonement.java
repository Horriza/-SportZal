package com.example.sportzal.model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="abonement")
public class Abonement {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Integer price;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "abonementID")
    private Set<Price> tasks = new HashSet<Price>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
