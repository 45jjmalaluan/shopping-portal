package com.ethoca.sp.comm.dto;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Transfer object class for a cart.
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
        Item item = findItemProduct(currCart, productId);
        if (item != null) {
            items.remove(item);
        }
    }

    public void updateProduct(Cart currCart, String productId, int quantity) {
        Item item = findItemProduct(currCart, productId);
        if (item != null) {
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                items.remove(item);
            }
        }
    }

    public void updateQuantity(Cart cartDto, Cart currCart) {
        if (cartDto != null) {
            for (Item dtoItem : cartDto.getItems()) {
                String dtoProductId = dtoItem.getProduct().getId();
                int quantity = dtoItem.getQuantity();
                updateProduct(currCart, dtoProductId, quantity);
            }
        }
    }

    private Item findItemProduct(Cart theCart, String productId) {
        Item foundItem = null;
        List<Item> items = theCart.getItems();
        for (Item item : items) {
            String itemProductId = item.getProduct().getId();
            if (StringUtils.equals(productId, itemProductId)) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }
}
