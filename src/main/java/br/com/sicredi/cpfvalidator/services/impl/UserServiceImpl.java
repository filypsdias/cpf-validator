package br.com.sicredi.cpfvalidator.services.impl;

import br.com.sicredi.cpfvalidator.services.UserService;
import io.swagger.model.UserCpfStatusDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

import static br.com.sicredi.cpfvalidator.constants.ResponseConstants.ABLE_TO_VOTE;
import static br.com.sicredi.cpfvalidator.constants.ResponseConstants.UNABLE_TO_VOTE;
import static br.com.sicredi.cpfvalidator.helpers.CpfValidator.isValidCpf;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserCpfStatusDTO validateCpf(final String cpf) {

        log.info("ValidatorServiceImpl.validateCpf - Start - Input - [{}]", cpf);
        log.debug("CampaignServiceImpl.create - Start - Input - [{}]", cpf);

        UserCpfStatusDTO user = new UserCpfStatusDTO();
        if (isValidCpf(cpf)) {
            user.setStatus(ABLE_TO_VOTE);
        } else {
            user.setStatus(UNABLE_TO_VOTE);
        }

        return user;
    }

}
