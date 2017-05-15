package com.ethoca.sp.comm.listener;

import com.ethoca.sp.comm.dto.Cart;
import com.ethoca.sp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class CartListener {
    private static final String CART = "cartDto";

    @Autowired
    private CartService cartService;

    // GET: Show Cart
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(HttpServletRequest request, Model model) {
        Cart myCart = cartService.get(request);
        model.addAttribute(CART, myCart);
        return "cart";
    }

    // POST: Update quantity of products in cart.
    @RequestMapping(value = { "/cart" }, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request,  Model model,
        @ModelAttribute(CART) Cart cartDto) {
        // Redirect to shopping cart page.
        return "redirect:/notFound";
    }
}
