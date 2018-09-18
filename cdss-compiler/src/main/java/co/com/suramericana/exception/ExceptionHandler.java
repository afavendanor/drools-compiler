package co.com.suramericana.exception;


import org.pmw.tinylog.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({DomainException.class})
    public ResponseEntity<ResponseError> domainExceptionHandler(DomainException ex) {
        ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        Logger.debug("Business Error: ", ex);
         return new ResponseEntity<ResponseError>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({Throwable.class})
    public ResponseEntity<ResponseError> technicalException(Throwable ex) {
        ResponseError response = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ha ocurrido un error en el servidor, por favor contacte al administrador");
        Logger.error(ex, "General System Error - {}", ex.getMessage());
        return new ResponseEntity<ResponseError>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
