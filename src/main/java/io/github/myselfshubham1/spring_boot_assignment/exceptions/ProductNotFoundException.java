package io.github.myselfshubham1.spring_boot_assignment.exceptions;



/**
 * exception when product not found
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
