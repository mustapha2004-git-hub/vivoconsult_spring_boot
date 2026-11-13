package com.vivoconsult.vivoconsultWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    IndexService indexser;

    @Autowired 
    ServicesService ServicesS;

    @Autowired
    AboutService aboutS;

    @GetMapping("/index")
    public String getContent(Model model) {
        model.addAttribute("indexpagecontent", indexser.getIndexContent(1));
        model.addAttribute("msg", new UserMessageSend()); // Assuming you want to add this attribute
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("msg", new UserMessageSend());
        return "contact";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("servicescontent", ServicesS.getAllServicesContent());
        model.addAttribute("msg", new UserMessageSend());
        return "services";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("aboutcontent", aboutS.getAboutContent(1));
        model.addAttribute("msg", new UserMessageSend());
        return "about";
    }

}
