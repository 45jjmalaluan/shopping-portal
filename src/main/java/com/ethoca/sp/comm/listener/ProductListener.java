package com.ethoca.sp.comm.listener;

import com.ethoca.sp.comm.dto.Cart;
import com.ethoca.sp.comm.dto.Product;
import com.ethoca.sp.comm.target.ProductRestClient;
import com.ethoca.sp.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@Controller
public class ProductListener {
    @Autowired
    private ProductRestClient productRestClient;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/products")
    public String viewAll(Model model, HttpServletRequest request) {
        List<Product> result = productRestClient.fetchAll();
        model.addAttribute("productDtos", result);
        return "products";
    }

    @RequestMapping(value = "/buyProduct")
    public String choosen(Model model, HttpServletRequest request, @RequestParam(value = "id", defaultValue = "") String productId) {
        Product product = null;
        /*
        if (StringUtils.isNoneEmpty(productId)) {
            product = productRestClient.fetch(productId);
        }
        if (product != null) {
            Cart cart = null;
            if (!cartService.existsInSession(request)) {
                // create the cart
                cart = new Cart();
                cart.addProduct(product,1);
                cart = cartService.create(cart);
                // store the cart in session
                cartService.save(request, cart);
            } else {
                // get the cart in session
                cartService.get(request);
            }
        }
         */
        // Redirect to shopping cart page.
        return "redirect:/notFound";
    }
}
