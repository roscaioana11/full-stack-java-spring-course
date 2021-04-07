package ro.fasttrackit.productsappcourse6homework.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundExceptions(ResourceNotFoundException ex) {
        return new ApiError(ex.getMessage());
    }

}

@Value
class ApiError {
    String message;
}
