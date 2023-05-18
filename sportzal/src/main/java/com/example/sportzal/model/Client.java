package com.example.sportzal.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="clients")
public class Client {
 @Id
   @Column(name="id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    @Column(name="name")
    private String name;
    @Column(name="birdh")
    private String birdh;
    @Column(name="phone")
    private String phone;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "clientsID")
    private Set<Client> tasks = new HashSet<Client>();

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

    public String getEmail() {
        return birdh;
    }

    public void setBirdh(String birdh) {
        this.birdh = birdh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
