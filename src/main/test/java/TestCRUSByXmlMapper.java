import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

public class TestCRUSByXmlMapper {

    /**
     * @Description: 添加用户
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/20
     */
    @Test
    public void testAdd() {
//        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        SqlSession sqlSession = MyBatisUtil.getSqlSession(false); //设置执行完sql之后 不自动提交事务
/**
 * 映射sql标识字符串
 */
        String statement = "mapping.userMapper.addUser"; //映射sql标识字符串
        User user = new User();
        user.setName("王咸鱼false");
        user.setAge(1000);
        user.setId(1);
//        执行插入操作
        int reResult = sqlSession.insert(statement, user);
//        因为getSqlSession设置的是自动提交事务 不需要手动提交 否则返回添加完成数据库无数据
//        手动提交事务
        sqlSession.commit();
        //使用sqlSession执行完sql语句之后需要关闭 sqlSession
        sqlSession.close();
        System.out.println(reResult);
    }

    /**
     * @Description: 修改用户
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/20
     */
    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        String statement = "mapping.userMapper.updateUser"; //映射sql标识字符串
        User user = new User();
        user.setId(1);
        user.setName("wcc");
        user.setAge(100);
        //执行修改操作
        int reResult = sqlSession.update(statement, user);
        //使用sqlSession执行完sql语句之后需要关闭 sqlSession
        sqlSession.close();
        System.out.println(reResult);
    }

    /**
     * @Description: 删除用户
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/20
     */
    @Test
    public void testDel() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        String statement = "mapping.userMapper.deleteUser"; //映射sql标识字符串
        int id = 9;
        int reResult = sqlSession.delete(statement, id);
        //使用sqlSession执行完sql语句之后需要关闭 sqlSession
        sqlSession.close();
        System.out.println(reResult);
    }

    /**
     * @Description: 查询所有的用户
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/20
     */
    @Test
    public void getAllUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        String statement = "mapping.userMapper.getAllUsers"; //映射sql标识字符串
        List<User> users = sqlSession.selectList(statement); //返回查询的所有用户 并用list封装
        //使用sqlSession执行完sql语句之后需要关闭 sqlSession
        sqlSession.close();
        System.out.println(users);

    }

}
