package io.github.futurewl;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述：自定义的 TypeHandler
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {

    private Logger logger = Logger.getLogger(MyTypeHandler.class);

    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("使用我的TypeHandler");
        ps.setString(i, parameter);
    }

    public String getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("使用我的TypeHandler,ResultSet 列名获取字符串");
        return rs.getString(columnName);
    }

    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.info("使用我的TypeHandler,ResultSet 下标获取字符串");
        return rs.getString(columnIndex);
    }

    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.info("使用我的TypeHandler,CallableStatement 下标获取字符串");
        return cs.getString(columnIndex);
    }
}
