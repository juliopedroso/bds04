package com.devsuperior.bds04.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }

    public List<FieldMessage> getErrors() {
        return this.errors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ValidationError)) {
            return false;
        }
        ValidationError validationError = (ValidationError) o;
        return Objects.equals(errors, validationError.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(errors);
    }

}
