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
}
