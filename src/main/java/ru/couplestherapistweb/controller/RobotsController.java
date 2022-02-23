package ru.couplestherapistweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RobotsController {

    @RequestMapping("/robots.txt")
    @ResponseBody
    public String robots() {
        return """
                User-agent: *
                Host: https://www.vladimirmoroz.ru
                Sitemap: https://www.vladimirmoroz.ru/sitemap.xml""";
    }
}
