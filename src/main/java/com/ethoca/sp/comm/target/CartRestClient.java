package com.ethoca.sp.comm.target;

import com.ethoca.sp.comm.dto.Cart;

import java.net.URI;

/**
 *
 */
public class CartRestClient extends AbstractRestClient<Cart> {
    public CartRestClient(String resouceUrl) {
        super(resouceUrl);
    }

    public Cart create(Cart cart) {
        URI uri = composeTargetUri(getResouceUrl());
        return post(uri, cart, Cart.class);
    }

    public void appendProduct(String carId, String productId, int quantity) {
        String resouceUrl = getResouceUrl() + "/{cartId}/product/{productId}/quantity/{quantity}";
        URI uri = composeTargetUri(resouceUrl, carId, productId, quantity);
        put(uri, Cart.class);
    }
}
