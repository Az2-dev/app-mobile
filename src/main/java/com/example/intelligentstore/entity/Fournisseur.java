package com.example.intelligentstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "numero")
    private String numero;
    @Column(name = "mail")
    private String mail;
    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Product> products;

    public Fournisseur() {
    }

    public Fournisseur(String name, String numero, String mail) {
        this.name = name;
        this.numero = numero;
        this.mail = mail;
    }

    public Fournisseur(String name, String numero, String mail, List<Product> products) {

        this.name = name;
        this.numero = numero;
        this.mail = mail;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
