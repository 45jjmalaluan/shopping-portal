package com.ethoca.sp.comm.listener;

import com.ethoca.sp.comm.dto.Cart;
import com.ethoca.sp.comm.dto.Product;
import com.ethoca.sp.comm.target.ProductRestClient;
import com.ethoca.sp.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class CartListener {
    private static final String CART = "cartDto";

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRestClient productRestClient;

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

    @RequestMapping({ "/removeCartProduct" })
    public String removeProductHandler(HttpServletRequest request,
        @RequestParam(value = "productId", defaultValue = "") String productId) {
        Product product = null;
        if (StringUtils.isNoneEmpty(productId)) {
            product = productRestClient.fetch(productId);
        }
        if (product != null) {
            // get the cart in session
            Cart cart = cartService.get(request);
            cart.removeProduct(cart, productId);
            cartService.removeProduct(cart.getId(), productId);
            // store the cart in session
            cartService.save(request, cart);
        }
        // Redirect to shopping cart page.
        return "redirect:/cart";
    }
}
