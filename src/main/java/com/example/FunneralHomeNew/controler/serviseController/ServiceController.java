package com.example.FunneralHomeNew.controler.serviseController;


import com.example.FunneralHomeNew.dto.UpdateServicePayload;
import com.example.FunneralHomeNew.models.service.Service;
import com.example.FunneralHomeNew.service.serviceImp.ServiceService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("main/services/{serviceId:\\d+}")
@RequiredArgsConstructor
@Slf4j
public class ServiceController {

    private final ServiceService serviceMenger;


    @ModelAttribute("service")
    public Service service(@PathVariable("serviceId") Long id) {
        return serviceMenger.getService(id).orElseThrow();
    }

    @GetMapping("/{id}")
    public String serviceInfo(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceMenger.getService(id));
        return "service/service_info";
    }


    @PostMapping("delete")
    public String deleteService(@ModelAttribute(name = "service") Service service) {
        serviceMenger.deleted(service.getId());
        return "redirect:/main/services/list";
    }


    @PostMapping("edit")
    public String updateService(@ModelAttribute(name = "service", binding = false) Service service,
                                UpdateServicePayload payload,
                                BindingResult bindingResult,
                                Model model) {


        if (bindingResult.hasErrors()) {
            List<String> errors = getErrors(bindingResult);

            model.addAttribute("service", payload);
            model.addAttribute("errors", errors);
            log.info("Не удалось обновить данные услуги. Ошибка: {}", errors);
            return "/main/services/edit";
        }

        else {
            serviceMenger.updateService(service.getId(), payload.title(), payload.price());
            log.info("Услуга обнавлена. Id: {}, название: {}, цена: {}", service.getId(),
                    payload.title(), payload.price());
        }
        return "redirect:/main/services/%d".formatted(service.getId());
    }

    private List<String> getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream().map(
                ObjectError::getDefaultMessage).toList();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException noSuchElementException, Model model,
                                               HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error", noSuchElementException.getMessage());
        return "errors/service/404";
    }
}
