package com.ethoca.sp.comm.dto;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Cart {
    private String id;

    private List<Item> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String idParam) {
        id = idParam;
    }

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

    public void removeProduct(Cart currCart, String productId) {
        Item removeCandidate = null;
        List<Item> items = currCart.getItems();
        for (Item item : items) {
            String itemProductId = item.getProduct().getId();
            if (StringUtils.equals(productId, itemProductId)) {
                removeCandidate = item;
                break;
            }
        }
        if (removeCandidate != null) {
            items.remove(removeCandidate);
        }
    }
}
