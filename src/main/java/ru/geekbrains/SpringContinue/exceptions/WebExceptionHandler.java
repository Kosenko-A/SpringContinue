package ru.geekbrains.SpringContinue.exceptions;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.SpringContinue.dto.ErrorDto;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDto> handlerNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
