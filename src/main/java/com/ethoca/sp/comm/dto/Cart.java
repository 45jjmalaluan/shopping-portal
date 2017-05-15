package com.ethoca.sp.comm.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Cart {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addProduct(Product product, int quantity) {
        BigDecimal value = product.getPrice().multiply(new BigDecimal(quantity));
        Item item = new Item(product, quantity, value);
        items.add(item);
    }
}
