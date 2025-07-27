package LLD.TransactionFilteringSystem.Exceptions;

import LLD.TransactionFilteringSystem.enums.ValidationErrorType;

public class TransactionValidationException extends RuntimeException{

    private ValidationErrorType validationErrorType;

    public TransactionValidationException(String message, ValidationErrorType validationErrorType) {
        super(message);
        this.validationErrorType = validationErrorType;
    }

    public ValidationErrorType getValidationErrorType() {
        return validationErrorType;
    }
}
