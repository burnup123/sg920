package com.sg.common.base.dao;

public enum  MysqlJdbcType {
    BIGINT("BIGINT"),
    BIT("BIT"),
    CHAR("CHAR"),
    TEXT("CLOB"),
    DATE("DATE"),
    DECIMAL("DECIMAL"),
    DOUBLE("DOUBLE"),
    FLOAT("FLOAT"),
    INTEGER("INTEGER"),
    INT("INTEGER"),
    NUMERIC("NUMERIC"),
    REAL("REAL"),
    SMALLINT("SMALLINT"),
    TIME("TIME"),
    TIMESTAMP("TIMESTAMP"),
    DATETIME("DATETIME"),
    TINYINT("TINYINT"),
    ENUM("VARCHAR"),
    VARCHAR("VARCHAR");
    private String jdbcType;
    private String getJdbcType(){
        return this.jdbcType;
    }
    private MysqlJdbcType(String jdbcType){
        this.jdbcType = jdbcType;
    }
    public String toString(){  //覆盖了父类Enum的toString()
        return jdbcType;
    }

}
