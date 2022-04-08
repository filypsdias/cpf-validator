package br.com.sicredi.cpfvalidator.controllers;

import br.com.sicredi.cpfvalidator.services.UserService;
import io.swagger.api.UsersApi;
import io.swagger.model.UserCpfStatusDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static br.com.sicredi.cpfvalidator.constants.UrlConstants.URI_VALIDATE_CPF;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController implements UsersApi {

    private final UserService service;

    @Override
    @GetMapping(value = URI_VALIDATE_CPF)
    public ResponseEntity<UserCpfStatusDTO> getUserCpfValidation(@PathVariable final String cpf) {

        log.info("UserController.getUserCpfValidation - Start - Input - [{}]", cpf);
        log.debug("UserController.getUserCpfValidation - Start - Input - Order: {}", cpf);

        UserCpfStatusDTO user = service.validateCpf(cpf);

        log.debug("UserController.getUserCpfValidation - End - Input: {} Output: {}", cpf, user);

        return ResponseEntity.ok(user);
    }
}
