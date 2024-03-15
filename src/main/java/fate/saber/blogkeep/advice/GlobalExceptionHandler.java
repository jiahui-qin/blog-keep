package fate.saber.blogkeep.advice;

import fate.saber.blogkeep.entity.BaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


// paramValidation
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<BaseResult<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        String errorMessage = fieldError.getField() +"字段校验失败: " +ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        BaseResult<Void> errorResult = new BaseResult<>(HttpStatus.BAD_REQUEST.value(), errorMessage, null);
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    // 这段代码中，@ControllerAdvice注解标记了GlobalExceptionHandler类，表示这是一个全局异常处理器。
    // @ExceptionHandler(BindException.class)注解指定了处理BindException异常的方法，当参数校验失败时会抛出BindException异常。
    // 在处理方法中，我们从异常中获取错误信息并构造一个包含错误信息的BaseResult对象，然后返回一个带有HTTP状态码400（Bad Request）的响应。
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<BaseResult<Void>> handleBindException(BindException ex) {
        String errorMessage = ex.getAllErrors().get(0).getDefaultMessage();
        BaseResult<Void> errorResult = new BaseResult<>(HttpStatus.BAD_REQUEST.value(), errorMessage, null);
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    // 处理其他类型的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<BaseResult<Void>> handleException(Exception ex) {
        BaseResult<Void> errorResult = new BaseResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error" + ex.getMessage(), null);
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


