package com.example.intelligentstore.dto;

public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private Long idcategory;
    private Long idfournisseur;

    public ProductDto(Long id, String title, String description, String image, double price, Long idcategory, Long idfournisseur) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.idcategory = idcategory;
        this.idfournisseur = idfournisseur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
    }

    public Long getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Long idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

}
