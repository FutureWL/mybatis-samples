package io.github.futurewl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 功能描述：MyBatis 案例记录
 */
public class MyBatisApplication2 {

    public static void main(String[] args) {
        SqlSession sqlSession;
        sqlSession = MyBatisUtil.getSqlSessionFactoryByXml().openSession();
//        sqlSession = MyBatisUtil.getSqlSessionFactoryByCode().openSession();
//        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//        Role role = roleMapper.findRole("角色名");
//        System.out.println("role_name = >" + role.getRoleName());

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserList();
        System.out.println("userList = >" + userList.size());
    }

}
