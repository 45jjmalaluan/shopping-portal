package com.ethoca.sp.service;

import com.ethoca.sp.comm.dto.Cart;

import javax.servlet.http.HttpServletRequest;

/**
 * Service interface for processing cart related operations.
 */
public interface CartService {
    Cart create(Cart cart);

    void appendProduct(String carId, String productId, int quantity);

    void removeProduct(String carId, String productId);

    void updateProduct(String carId, String productId, int quantity);

    void save(HttpServletRequest request, Cart cart);

    Cart get(HttpServletRequest request);

    boolean existsInSession(HttpServletRequest request);
}
