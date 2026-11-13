package com.vivoconsult.vivoconsultWebsite;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AboutService {
    
    @Autowired
    AboutRepository aboutR;

    public AboutContent getAboutContent(int theid) {
        return aboutR.findById(theid).get();
    }

    public String UpdateAboutContent(AboutContent aboutContent) {
        Optional<AboutContent> AboutContentOptional = aboutR.findById(aboutContent.getId());
        if (AboutContentOptional.isPresent()) {
            aboutR.save(aboutContent);
            return "aboutcontent updated successfully";
        }
        return "aboutcontent not found";
    }
    
}
