package br.com.sicredi.cpfvalidator.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SwaggerController {

    @GetMapping("/{name}/{version}")
    public String homePage(@PathVariable("name") final String name,
                           @PathVariable("version") final String version,
                           final Model model) {
        model.addAttribute("filePath", "/swagger/" + name + '/' + version + "/ms-cpf-validator.yaml");
        return "redoc";
    }
}
