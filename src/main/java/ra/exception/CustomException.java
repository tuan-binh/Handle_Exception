package ra.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception
{
	private HttpStatus httpStatus;
	
	public CustomException(String message, HttpStatus status)
	{
		super(message);
		this.httpStatus = status;
	}
}
