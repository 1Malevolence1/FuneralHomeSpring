package com.example.FunneralHomeNew.controler;


import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceMenger;

    @GetMapping("/")
    public String service(Model model){
        model.addAttribute("services", serviceMenger.getServicesList());
        return "services";
    }
    @GetMapping("/service/{id}")
    public String serviceInfo(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceMenger.getService(id));
        return "service-info";
    }


    @PostMapping("/service/create")
    public String createProduct( Service service)   {
        serviceMenger.addService(service);
        return "redirect:/";
    }

    @PostMapping("/service/delete/{id}")
    String deleteService(@PathVariable Long id){
        serviceMenger.deletedService(id);
        return "redirect:/";
    }
}
