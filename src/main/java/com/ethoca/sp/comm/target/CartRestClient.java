package com.ethoca.sp.comm.target;

import com.ethoca.sp.comm.dto.Cart;

import java.net.URI;

/**
 * Rest client class for a cart.
 */
public class CartRestClient extends AbstractRestClient<Cart> {
    public CartRestClient(String resouceUrl) {
        super(resouceUrl);
    }

    public Cart create(Cart cart) {
        URI uri = composeTargetUri(getResouceUrl());
        return post(uri, Cart.class, cart);
    }

    public void appendProduct(String carId, String productId, int quantity) {
        String resouceUrl = getResouceUrl() + "/{cartId}/product/{productId}/quantity/{quantity}";
        URI uri = composeTargetUri(resouceUrl, carId, productId, quantity);
        post(uri, Cart.class, null);
    }

    public void removeProduct(String carId, String productId) {
        String resouceUrl = getResouceUrl() + "/{cartId}/product/{productId}";
        URI uri = composeTargetUri(resouceUrl, carId, productId);
        delete(uri);
    }

    public void updateProduct(String carId, String productId, int quantity) {
        String resouceUrl = getResouceUrl() + "/{cartId}/product/{productId}/quantity/{quantity}";
        URI uri = composeTargetUri(resouceUrl, carId, productId, quantity);
        put(uri, Cart.class);
    }
}
