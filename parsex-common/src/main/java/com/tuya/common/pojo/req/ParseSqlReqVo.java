package com.tuya.common.pojo.req;

public class ParseSqlReqVo {
    private String type;
    private String sql;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "ParseSqlReqVo{" +
                "type='" + type + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
