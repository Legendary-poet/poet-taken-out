package com.superpoet.util;

/**
 * <p>
 * 自定义业务异常类
 * </p>
 *

 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
