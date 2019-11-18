package com.mainacad.model;

import java.math.BigDecimal;
public class Item {

    private String itemId;
    private String name;
    private String url;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal initialPrice;
    private String availability;

    public Item(String itemId, String name, String url, String imageUrl, BigDecimal price, BigDecimal initialPrice, String availability) {
        this.itemId = itemId;
        this.name = name;
        this.url = url;
        this.imageUrl = imageUrl;
        this.price = price;
        this.initialPrice = initialPrice;
        this.availability = availability;
    }

    public Item() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "itemId: " + itemId + ", name: " + name + ", url: " + url + ", imageUrl: " + imageUrl +
                ", price: " + price + ", initialPrice: " + initialPrice + ", availability: " + availability;
    }
}
