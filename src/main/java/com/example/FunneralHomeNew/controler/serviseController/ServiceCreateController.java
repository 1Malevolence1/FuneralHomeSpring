package com.example.FunneralHomeNew.controler.serviseController;


import com.example.FunneralHomeNew.record.service.NewServicePayload;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.serviceImp.ServiceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/services/create")
@Slf4j
public class ServiceCreateController {

    private ServiceService serviceMenger;

    @Autowired
    public ServiceCreateController(ServiceService serviceMenger) {
        this.serviceMenger = serviceMenger;
    }

    @GetMapping()
    public String createServicePage(){
        return "main/services/service_new";
    }


    @PostMapping()
    public String createNewService(@Valid NewServicePayload newServicePayload, BindingResult bindingResult,
                                   Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("payload", newServicePayload);
            model.addAttribute("errors", bindingResult.getAllErrors().stream().
                    map(ObjectError::getDefaultMessage).toList());
            log.info(String.valueOf(bindingResult.getAllErrors().stream().
                    map(ObjectError::getDefaultMessage).toList()));
            return "main/services/service_new";
        }
        else {
            Service service = serviceMenger.createService(newServicePayload.title(), newServicePayload.price());
            return "redirect:/main/services/%d".formatted(service.getId());
        }
    }
}
