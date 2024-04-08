package com.example.FunneralHomeNew.controler;

import com.example.FunneralHomeNew.Validator.contract.ValidatorContract;
import com.example.FunneralHomeNew.config.colors.Colors;
import com.example.FunneralHomeNew.exception.ExceptionValidator;
import com.example.FunneralHomeNew.models.contract.Contract;
import com.example.FunneralHomeNew.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Slf4j
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
        ValidatorContract validatorContract = new ValidatorContract();

        if(Objects.nonNull(validatorContract.check(contract))){
            contractService.buildingContract(contract, mService, mEmployee);
            contractService.add(contract);
            model.addAttribute("contractCreated", Boolean.TRUE);
        } else {

            model.addAttribute("contractCreated", Boolean.FALSE);
            log.info("Не удалось создать контракт: " + Colors.ANSI_GREEN +  "{}" , contract);
        }


        return contract(model);
    }



    @PostMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id, Model model){
        contractService.deleted(id);
        return contract(model);
    }
}


