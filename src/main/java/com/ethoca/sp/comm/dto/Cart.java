package com.ethoca.sp.comm.dto;

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

    /*
    public void updateProduct(String productId, int quantity) {
        CartLineInfo item = this.findLineByCode(code);

        if (item != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    public void updateQuantity(Cart cartReq) {
        if (cartReq != null) {
            List<Item> items = cartReq.getItems();
            for (Item item : items) {
                this.updateProduct(item.getProduct().getId(), item.getQuantity());
            }
        }
    }
     */
}
