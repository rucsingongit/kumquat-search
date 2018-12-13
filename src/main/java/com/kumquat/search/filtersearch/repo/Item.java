package com.kumquat.search.filtersearch.repo;

import java.util.Objects;

public class Item {

    private String category;

    private String brand;

    private String color;

    private Double price;

    public Item() {
    }

    public Item(String category, String brand, String color, Double price) {
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(category, item.category) &&
                Objects.equals(brand, item.brand) &&
                Objects.equals(color, item.color) &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, brand, color, price);
    }
}
