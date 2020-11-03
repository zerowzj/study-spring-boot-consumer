package study.springcloud.consumer.rest.support.exception;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public Map<String, Object> resolveException(Exception ex) {
        ex.printStackTrace();
        Map<String, Object> data = Maps.newHashMap();
        data.put("code", "9999");
        data.put("desc", ex.getMessage());
        return data;
    }
}
