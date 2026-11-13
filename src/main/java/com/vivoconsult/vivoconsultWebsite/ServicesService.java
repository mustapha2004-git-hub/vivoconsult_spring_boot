package com.vivoconsult.vivoconsultWebsite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {

    @Autowired
    ServicesRepository ServicesRep;

    public List<ServicesContent> getAllServicesContent() {
        return ServicesRep.findAll();
    }

    public ServicesContent getServicesContent(int theid) {
        return ServicesRep.findById(theid).get();
    }

    public String updateServicesContent(ServicesContent servicesContent) {
        Optional<ServicesContent> ServicesContentOptional = ServicesRep.findById(servicesContent.getId());
        if (ServicesContentOptional.isPresent()) {
            ServicesRep.save(servicesContent);
            return "ServicesContent updated successfully";
        }
        return "ServicesContent not found";
    }

    public void removeService(int id) {
        ServicesRep.deleteById(id);
    }

    public String createService(ServicesContent servicesContent) throws Exception {
        ServicesRep.save(servicesContent);
        return "service added successfully";
    }

}
