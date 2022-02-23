package ru.couplestherapistweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SitemapController {
    @RequestMapping("/sitemap.xml")
    @ResponseBody
    public String sitemap() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
                   <url>
                      <loc>https://vladimirmoroz.ru/</loc>
                      <lastmod>2022-02-01</lastmod>
                      <changefreq>daily</changefreq>
                      <priority>1.0</priority>
                   </url>
                </urlset>""";
    }
}
