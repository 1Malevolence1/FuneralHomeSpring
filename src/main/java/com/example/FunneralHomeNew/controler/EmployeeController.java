package com.example.FunneralHomeNew.controler;

import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.ServiceEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final ServiceEmployee serviceEmployee;

    @GetMapping()
    public String employee(Model model){
        model.addAttribute("services", serviceEmployee.getList());
        return "service/services";
    }
    @GetMapping("/{id}")
    public String serviceInfo(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceEmployee.getObject(id));
        return "service/service-info";
    }
    @PostMapping("/create")
    public String createProduct(Employee employee, Model model)   {
        serviceEmployee.add(employee);
        return employee(model);
    }

    @PostMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id, Model model){
        serviceEmployee.deleted(id);
        return employee(model);
    }
}
