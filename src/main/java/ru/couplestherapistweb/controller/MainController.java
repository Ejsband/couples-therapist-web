package ru.couplestherapistweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.couplestherapistweb.service.*;

import java.util.Map;

@Controller
@PropertySource("classpath:web.properties")
@RequiredArgsConstructor
public class MainController {

    @Value( "${indexHtml}" )
    private String indexHtml;
    @Value( "${instructionHtml}" )
    private String instructionHtml;
    @Value( "${policyHtml}" )
    private String policyHtml;
    @Value( "${commonCss}" )
    private String commonCss;
    @Value( "${indexCss}" )
    private String indexCss;
    @Value( "${instructionCss}" )
    private String instructionCss;
    @Value( "${policyCss}" )
    private String policyCss;
    @Value( "${commonJs}" )
    private String commonJs;

    private final AgreementService agreementService;
    private final ContactService contactService;
    private final ServiceService serviceService;
    private final UtilityService utilityService;
    private final DataService dataService;

    @GetMapping("/")
    public String getIndexPage(Model model) {

        model.addAttribute("individual", serviceService.findByName("individual"));
        model.addAttribute("group", serviceService.findByName("group"));

        Map<Integer, String> map = utilityService.generateCaptcha();
        model.addAttribute("captchaText", utilityService.getCaptchaString(map));
        model.addAttribute("captchaNumber", utilityService.getCaptchaNumber(map));

        model.addAttribute("agreement", agreementService.findByName("agreement"));

        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));

        model.addAttribute("yandexVerification", dataService.findByName("yandexVerification"));

        model.addAttribute("commonCss", commonCss);
        model.addAttribute("indexCss", indexCss);
        model.addAttribute("commonJs", commonJs);
        return indexHtml;
    }

    @GetMapping("/instruction")
    public String getInstructionPage(Model model) {
        model.addAttribute("agreement", agreementService.findByName("agreement"));

        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));

        model.addAttribute("yandexVerification", dataService.findByName("yandexVerification"));

        model.addAttribute("commonCss", commonCss);
        model.addAttribute("instructionCss", instructionCss);
        model.addAttribute("commonJs", commonJs);
        return instructionHtml;
    }

    @GetMapping("/policy")
    public String getPolicyPage(Model model) {
        model.addAttribute("agreement", agreementService.findByName("agreement"));
        model.addAttribute("policy", agreementService.findByName("policy"));

        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));

        model.addAttribute("yandexVerification", dataService.findByName("yandexVerification"));

        model.addAttribute("commonCss", commonCss);
        model.addAttribute("policyCss", policyCss);
        model.addAttribute("commonJs", commonJs);
        return policyHtml;
    }
}
