package ra.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.exception.CustomException;
import ra.model.dto.DateResponse;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ApplicationHandler
{
	/**
	 * @param ex MethodArgumentNotValidException
	 * @return ResponseEntity<errors>
	 * @apiNote handle validation form request
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValid(MethodArgumentNotValidException ex)
	{
		Map<String, String> errors = new HashMap<>();
		/**
		 * {
		 *    "email":"email is not valid",
		 *    "password":"password must be not null"
		 * }
		 * */
		ex.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(
				  new DateResponse(errors, HttpStatus.BAD_REQUEST)
		);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleCustomException(CustomException ex)
	{
		return new ResponseEntity<>(
				  new DateResponse(ex.getMessage(), ex.getHttpStatus()),
				  ex.getHttpStatus()
		);
	}
	
	
}
