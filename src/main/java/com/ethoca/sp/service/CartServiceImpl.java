package com.ethoca.sp.service;

import com.ethoca.sp.comm.dto.Cart;
import com.ethoca.sp.comm.target.CartRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Service
public class CartServiceImpl implements CartService {
    private static final String CART = "myCart";

    @Autowired
    private CartRestClient cartRestClient;

    @Override
    public Cart create(Cart cart) {
        return cartRestClient.create(cart);
    }

    @Override
    public void appendProduct(String carId, String productId, int quantity) {
        cartRestClient.appendProduct(carId, productId, quantity);
    }

    @Override
    public void save(HttpServletRequest request, Cart cart) {
        request.getSession().setAttribute(CART, cart);
    }

    @Override
    public Cart get(HttpServletRequest request) {
        // Get Cart from Session.
        return (Cart) request.getSession().getAttribute(CART);
    }

    @Override
    public boolean existsInSession(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute(CART);
        if (cart == null) {
            return false;
        }
        return true;
    }
}
