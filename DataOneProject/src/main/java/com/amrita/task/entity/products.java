package com.amrita.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class products {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float price;
    private String brand;
    private boolean onSale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override public String toString() {
        return "products{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price
            + ", brand='" + brand + '\'' + ", onSale=" + onSale + '}';
    }
}
