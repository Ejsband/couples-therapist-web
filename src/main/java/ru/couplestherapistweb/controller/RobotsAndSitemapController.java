package ru.couplestherapistweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PropertySource("classpath:web.properties")
public class RobotsAndSitemapController {

    @Value( "${lastmod}" )
    private String lastmod;
    @Value( "${changefreq}" )
    private String changefreq;

    @RequestMapping("/robots.txt")
    @ResponseBody
    public String robots() {
        return """
                User-agent: *
                Disallow: /policy
                Disallow: /custom/file/agreement.pdf
                Host: https://vladimirmoroz.ru
                Sitemap: https://vladimirmoroz.ru/sitemap.xml
                """;
    }

    @RequestMapping("/sitemap.xml")
    @ResponseBody
    public String sitemap() {
        return """
                <?xml version="1.0" encoding="utf-8"?>
                <urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
                   <url>
                      <loc>https://vladimirmoroz.ru/</loc>
                      <lastmod>%s</lastmod>
                      <changefreq>%s</changefreq>
                      <priority>1.0</priority>
                   </url>
                   <url>
                      <loc>https://vladimirmoroz.ru/instruction</loc>
                      <lastmod>%s</lastmod>
                      <changefreq>%s</changefreq>
                      <priority>0.9</priority>
                   </url>
                </urlset>
                """.formatted(lastmod, changefreq, lastmod, changefreq);
    }
}
