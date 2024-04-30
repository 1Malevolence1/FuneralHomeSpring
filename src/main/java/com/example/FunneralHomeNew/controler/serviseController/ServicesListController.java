package com.example.FunneralHomeNew.controler.serviseController;


import com.example.FunneralHomeNew.service.serviceImp.ServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("main/services")
@RequiredArgsConstructor
@Slf4j
public class ServicesListController {



    private final ServiceService serviceMenger;

    @GetMapping("list")
    public String service(Model model){
        model.addAttribute("services", serviceMenger.getList());
        return "main/services/list";
    }



}
