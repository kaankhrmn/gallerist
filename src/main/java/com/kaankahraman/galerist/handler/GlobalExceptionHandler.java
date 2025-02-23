package com.kaankahraman.galerist.handler;

import com.kaankahraman.galerist.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = {BaseException.class})
//    public ResponseEntity<String> handleBaseExest(BaseException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }


    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException e, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(e.getMessage(), request));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        Map<String, List<String>> map = new HashMap<>();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objectError).getField();

            if (map.containsKey(fieldName)) {
                map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
            } else {
                map.put(fieldName, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(map, request));
    }

    private List<String> addValue(List<String> list, String value) {
        list.add(value);
        return list;
    }


    private String getHostName() {
        try {
            Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();
        exception.setPath(request.getDescription(false));
        exception.setCreateTime(new Date());
        exception.setMessage(message);
        exception.setHostName(getHostName());

        apiError.setException(exception);

        return apiError;
    }
}
