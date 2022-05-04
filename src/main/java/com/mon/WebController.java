package com.mon;

import com.mon.data.BAERepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    BAERepository repository;

    WebController(BAERepository repository) {
        this.repository = repository;
    }
    @Value("${page.refresh:30}")
    String refreshInterval;

    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("errors", repository.findAll());
        model.addAttribute("lastChecked", "Last error checked @ " +
                Utils.getFormattedCurrentTime());
        model.addAttribute("interval", refreshInterval);
        return "home";

    }


}
