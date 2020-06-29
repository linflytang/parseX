package com.tuya.server.controller;

import com.tuya.common.exceptions.SqlParseException;
import com.tuya.common.model.Result;
import com.tuya.core.AbstractSqlParse;
import com.tuya.core.HiveSQLParse;
import com.tuya.core.PrestoSqlParse;
import com.tuya.core.SparkSQLParse;
import com.tuya.server.exception.RestExceptionHandler;
import com.tuya.common.pojo.RestResult;
import com.tuya.common.pojo.RestResultGenerator;
import com.tuya.common.pojo.req.ParseSqlReqVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class SqlParseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @PostMapping(value = "/parse")
    public RestResult<Result> parse(@RequestBody ParseSqlReqVo reqVo) throws SqlParseException {
        AbstractSqlParse sqlParse = null;
        switch (reqVo.getType()) {
            case "hive":
                sqlParse = new HiveSQLParse();
                break;
            case "presto":
                sqlParse = new PrestoSqlParse();
                break;
            case "spark":
                sqlParse = new SparkSQLParse();
                break;
            default:
                sqlParse = new HiveSQLParse();
        }
        LOGGER.info("Parse type: {}, sql: {}", reqVo.getType(), reqVo.getSql());
        return RestResultGenerator.genSuccessResult(sqlParse.parse(reqVo.getSql()));
    }
}
