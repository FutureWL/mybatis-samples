package io.github.futurewl;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 功能描述：通过 XML 文件构建 SQL 会话
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByXml() {
        if (sqlSessionFactory == null) {
            try {
                String resource = "mybatis_config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                return sqlSessionFactory;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 功能描述：通过 XML 文件构建 SQL 会话
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByXml2() {
        if (sqlSessionFactory == null) {
            try {
                String resource = "mybatis_config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                return sqlSessionFactory;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 功能描述：通过 代码 文件构建 SQL 会话
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByCode() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_sds_mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        configuration.addMapper(RoleMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }


}
