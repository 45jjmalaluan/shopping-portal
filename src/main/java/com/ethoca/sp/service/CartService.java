package com.ethoca.sp.service;

import com.ethoca.sp.comm.dto.Cart;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public interface CartService {
    Cart create(Cart cart);

    void save(HttpServletRequest request, Cart cart);

    Cart get(HttpServletRequest request);

    boolean existsInSession(HttpServletRequest request);
}