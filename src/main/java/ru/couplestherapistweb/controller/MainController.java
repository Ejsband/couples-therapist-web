package ru.couplestherapistweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.couplestherapistweb.service.AgreementService;
import ru.couplestherapistweb.service.ContactService;
import ru.couplestherapistweb.service.ServiceService;

@Controller
public class MainController {

    private final AgreementService agreementService;
    private final ContactService contactService;
    private final ServiceService serviceService;

    @Autowired
    public MainController(AgreementService agreementService, ContactService contactService, ServiceService serviceService) {
        this.agreementService = agreementService;
        this.contactService = contactService;
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("policy", agreementService.findByName("policy"));
        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));
        model.addAttribute("individual", serviceService.findByName("individual"));
        model.addAttribute("group", serviceService.findByName("group"));
        return "index";
    }

    @GetMapping("/instruction")
    public String getInstructionPage(Model model) {
        model.addAttribute("policy", agreementService.findByName("policy"));
        model.addAttribute("phone", contactService.findByName("phone"));
        model.addAttribute("email", contactService.findByName("email"));
        return "instruction";
    }
}
