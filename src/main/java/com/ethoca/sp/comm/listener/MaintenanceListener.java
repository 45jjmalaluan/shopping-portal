package com.ethoca.sp.comm.listener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for a maintenance page.
 */
@Controller
public class MaintenanceListener {
    @RequestMapping(value = "/notFound")
    public String getMaintenancePage() {
        return "notFound";
    }
}
