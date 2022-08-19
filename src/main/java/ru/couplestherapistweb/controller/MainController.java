package ru.couplestherapistweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.couplestherapistweb.service.*;

import java.util.Map;

@Controller
@PropertySource("classpath:web.properties")
public class MainController {

    @Value( "${index}" )
    private String index;

    @Value( "${instruction}" )
    private String instruction;

    @Value( "${policy}" )
    private String policy;

    private final AgreementService agreementService;
    private final ContactService contactService;
    private final ServiceService serviceService;
    private final UtilityService utilityService;

    @Autowired
    public MainController(AgreementService agreementService, ContactService contactService, ServiceService serviceService, UtilityService utilityService) {
        this.agreementService = agreementService;
        this.contactService = contactService;
        this.serviceService = serviceService;
        this.utilityService = utilityService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("agreement", agreementService.findByName("agreement"));
        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));
        model.addAttribute("individual", serviceService.findByName("individual"));
        model.addAttribute("group", serviceService.findByName("group"));
        Map<Integer, String> map = utilityService.generateCaptcha();
        model.addAttribute("captchaText", utilityService.getCaptchaString(map));
        model.addAttribute("captchaNumber", utilityService.getCaptchaNumber(map));
        return index;
    }

    @GetMapping("/instruction")
    public String getInstructionPage(Model model) {
        model.addAttribute("agreement", agreementService.findByName("agreement"));
        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));
        return instruction;
    }

    @GetMapping("/policy")
    public String getPolicyPage(Model model) {
        model.addAttribute("agreement", agreementService.findByName("agreement"));
        model.addAttribute("policy", agreementService.findByName("policy"));
        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));
        return policy;
    }
}
