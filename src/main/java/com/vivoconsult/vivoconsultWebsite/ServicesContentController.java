package com.vivoconsult.vivoconsultWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/servicesContent")
public class ServicesContentController {

    @Autowired
    ServicesService ServicesS;

    @Autowired
    UserService userS;

    @GetMapping
    public String getServicesContent(Model model) {
        model.addAttribute("servicescontent", ServicesS.getAllServicesContent());
        model.addAttribute("unreadmessages",userS.UnreadMessagesCounter());
        return "adminPages/ServicesC";
    }

    @GetMapping("/viewservice")
    public String getService(@RequestParam(name = "id") int theid, Model model) {
        model.addAttribute("servicecontent", ServicesS.getServicesContent(theid));
        return "adminPages/modifyServices";
    }

    @PostMapping("/updateservice")
    public String putServiceContent(ServicesContent servicesContent, @RequestPart("imagefile") MultipartFile imageFile)
            throws Exception {
        if (!imageFile.isEmpty())
            servicesContent.setCardImg(imageFile.getBytes());
        else
            servicesContent.setCardImg(ServicesS.getServicesContent(servicesContent.getId()).getCardImg());
        String str = ServicesS.updateServicesContent(servicesContent);
        return "redirect:/servicesContent";
    }

    @GetMapping("/delete")
    public String ServiceDelete(@RequestParam(name = "id") int id) {
        ServicesS.removeService(id);
        return "redirect:/servicesContent";
    }

    @GetMapping("/add")
    public String addService() {
        return "adminPages/add-service";
    }

    @PostMapping("/create")
    public String postService(ServicesContent servicesContent, @RequestPart("imagefile") MultipartFile imageFile) throws Exception {
        servicesContent.setCardImg(imageFile.getBytes());
        String str = ServicesS.createService(servicesContent);
        return "redirect:/servicesContent";
    }

}
