package com.ethoca.sp.comm.listener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for a home page.
 */
@Controller
public class IndexListener {
    @RequestMapping(value = "/")
    public String getHomePage() {
        return "index";
    }
}
