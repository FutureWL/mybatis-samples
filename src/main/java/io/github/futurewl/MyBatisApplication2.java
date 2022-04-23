package io.github.futurewl;

import org.apache.ibatis.session.SqlSession;

/**
 * 功能描述：MyBatis 案例记录
 */
public class MyBatisApplication2 {

    public static void main(String[] args) {
        SqlSession sqlSession;
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);
        System.out.println("role_name = >" + role.getRoleName());
    }

}
