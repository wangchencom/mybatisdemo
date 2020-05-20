import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class testCRUSByXmlMapper {
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
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        String statement = "mapping.userMapper.deleteUser"; //映射sql标识字符串

    }
    @Test
    public void testDel() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true); //设置执行完sql之后 自动提交事务
        String statement = "mapping.userMapper.deleteUser"; //映射sql标识字符串
    }

}
