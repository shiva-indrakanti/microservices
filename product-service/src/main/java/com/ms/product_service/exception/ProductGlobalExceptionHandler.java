package com.ms.product_service.exception;

import com.ms.product_service.constants.ProductConstants;
import com.ms.product_service.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ProductGlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(ProductAlreadyExistsException exception,
                                                                                 WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                ProductConstants.PRODUCT_ALREADY_EXIST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(Integer.parseInt(ProductConstants.PRODUCT_BAD_REQUEST)).body(errorResponseDTO);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ProductNotFoundException exception,WebRequest request){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                request.getDescription(false),
                ProductConstants.PRODUCT_NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(Integer.parseInt(ProductConstants.PRODUCT_NOT_FOUND)).body(errorResponseDTO);
    }
}
