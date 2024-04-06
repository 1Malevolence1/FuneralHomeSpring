package com.example.FunneralHomeNew.controler;

import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
@AllArgsConstructor
public class ContractController {

    private final ContractService contractService;

    // должнен возвращать списко конрактов
    @GetMapping()
    public String contract(Model model){
        model.addAttribute("contracts", contractService.getList());
        return "contract/contracts";

    }


    // Должен вернуть объект конракта со всеми его данными
    @GetMapping("/{id}")
    public String contractInfo(@PathVariable Long id, Model model) {
        Contract contract = contractService.getObject(id);
        model.addAttribute("contract", contract);
        model.addAttribute("services", contract.getListService());
        model.addAttribute("employees", contract.getListEmployee());
        return "contract/contract-info";
    }


    // Должен будет сохранять конракт
    @PostMapping("/create")
    public String createContract(Contract contract, Model model, @RequestParam("massiveService") String mService,
                                 @RequestParam("massiveEmployees") String mEmployee) throws ExceptionValidator {
        contractService.addServiceToTheContract(contract, mService);
        contract.setTotalAmountForServices(contractService.totalAmountForServices(contract.getListService()));

        contractService.addSEmployeeToTheContract(contract, mEmployee);
        contractService.add(contract);

        return contract(model);
    }



   /* @PostMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id, Model model){
        erviceMenger.deleted(id);
        return service(model);
        return "";
    }*/
}


