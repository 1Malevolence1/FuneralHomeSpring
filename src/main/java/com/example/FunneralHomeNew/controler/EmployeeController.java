package com.example.FunneralHomeNew.controler;

import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.repository.PassportRepository;
import com.example.FunneralHomeNew.service.ServiceEmployee;
import com.example.FunneralHomeNew.service.ServicePassport;
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
        model.addAttribute("employees", serviceEmployee.getList());
        return "employee/employees";
    }
    @GetMapping("/{id}")
    public String InfoEmployee(@PathVariable Long id, Model model) {

        model.addAttribute("employee", serviceEmployee.getObject(id));
        return "employee/employee-info";
    }
    @PostMapping("/create")
    public String createEmployee(Employee employee, Passport passport, Model model)
    {serviceEmployee.add(employee);
        return employee(model);
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        serviceEmployee.deleted(id);
        return employee(model);
    }
}


