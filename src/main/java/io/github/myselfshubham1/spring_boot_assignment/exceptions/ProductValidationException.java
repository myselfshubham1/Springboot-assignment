package io.github.myselfshubham1.spring_boot_assignment.exceptions;


/**
 * exception for validation error
 */
public class ProductValidationException extends RuntimeException {
    public ProductValidationException(String message) {
        super(message);
    }
}
