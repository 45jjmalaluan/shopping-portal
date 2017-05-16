package com.ethoca.sp.comm.dto;

import java.math.BigDecimal;

/**
 *
 */
public class Item {
    private Product product;

    private Integer quantity;

    private BigDecimal price;

    public Item(Product product, Integer quantity, BigDecimal price) {
        setProduct(product);
        setQuantity(quantity);
        setPrice(price);
    }

    public Item() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return getProduct().getPrice().multiply(new BigDecimal(getQuantity()));
    }
}
