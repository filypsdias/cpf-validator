package br.com.sicredi.cpfvalidator.exceptions;

import br.com.sicredi.cpfvalidator.constants.ErrorMessages;
import io.swagger.model.ErrorCodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public abstract class BaseException extends RuntimeException {

    private ErrorCodeEnum errorCodeEnum;
    private ErrorMessages errorMessages;

    public BaseException(
            final ErrorCodeEnum errorCodeEnum,
            final ErrorMessages errorMessages,
            final String message) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
        this.errorMessages = errorMessages;
    }

    public String getErrorMessage() {
        return errorMessages.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorMessages.getHttpStatus();
    }
}