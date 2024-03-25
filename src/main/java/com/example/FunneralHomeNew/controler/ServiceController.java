package com.example.FunneralHomeNew.controler;


import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.ServiceService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceMenger;
    @GetMapping()
    public String service(Model model){
        model.addAttribute("services", serviceMenger.getServicesList());
        return "service/services";
    }
    @GetMapping("/{id}")
    public String serviceInfo(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceMenger.getService(id));
        return "service/service-info";
    }




    @PostMapping("/create")
    public String createProduct(Service service, Model model)   {
        serviceMenger.addService(service);
        return service(model);
    }

    @PostMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id, Model model){
        serviceMenger.deletedService(id);
        return service(model);
    }

}
