package karinz.webmvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice digunakan untuk menangani error yang terjadi di seluruh aplikasi
 * dan memberikan response yang sesuai, misalnya dengan mengembalikan error JSON atau HTML.
 */
@ControllerAdvice
public class ErrorController {

    /**
     * Annotation @ExceptionHandler digunakan untuk menangani exception tertentu
     * dan juga untuk menangkap exception dan mengubah response
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body("Validation Error : " + exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> ConstraintViolationException(ConstraintViolationException exception) {
        return ResponseEntity.badRequest().body("Validation Error : " + exception.getMessage());
    }
}
