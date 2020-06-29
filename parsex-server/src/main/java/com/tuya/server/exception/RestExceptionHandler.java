package com.tuya.server.exception;

import com.tuya.common.exceptions.SqlParseException;
import com.tuya.common.pojo.ErrorCode;
import com.tuya.common.pojo.RestResult;
import com.tuya.common.pojo.RestResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> runtimeExceptionHandler(Exception e) {
        LOGGER.error("---------> internal server error!", e);
        return RestResultGenerator.genErrorResult(ErrorCode.ERROR_SERVER_ERROR);
    }

    @ExceptionHandler(SqlParseException.class)
    @ResponseBody
    private <T> RestResult<T> sqlParseExceptionHandler(SqlParseException e) {
        LOGGER.error("---------> invalid sql!", e);
        return RestResultGenerator.genErrorResult(ErrorCode.ERROR_SQL_PARSE, e.getMessage());
    }
}
