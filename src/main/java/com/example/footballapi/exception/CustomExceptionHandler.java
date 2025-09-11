package com.example.footballapi.exception;

import com.example.footballapi.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class
    })
    private ResponseEntity<ExceptionDTO> handleMethodArgumentNotValidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(
                        exception.getClass().getSimpleName(),
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler({
            AccessDeniedException.class,
            AuthenticationException.class,
            BadCredentialsException.class,
            InternalAuthenticationServiceException.class
    })
    private ResponseEntity<ExceptionDTO> handleBadCredentialsException(Exception exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ExceptionDTO(
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler({DisabledException.class, NoSuchElementException.class, UsernameNotFoundException.class})
    private ResponseEntity<ExceptionDTO> handleNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDTO(
                        exception.getClass().getSimpleName(),
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<ExceptionDTO> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ExceptionDTO(
                        exception.getClass().getSimpleName(),
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionDTO> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionDTO(
                        exception.getClass().getSimpleName(),
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }
}
