package br.com.sicredi.cpfvalidator.services;

import io.swagger.model.UserCpfStatusDTO;

public interface UserService {

    UserCpfStatusDTO validateCpf(final String cpf);

}
