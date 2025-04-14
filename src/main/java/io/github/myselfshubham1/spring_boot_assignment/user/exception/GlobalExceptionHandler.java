package io.github.myselfshubham1.spring_boot_assignment.user.exception;

public class GlobalExceptionHandler extends RuntimeException {
    public GlobalExceptionHandler(String message) {
        super(message);
    }
}
