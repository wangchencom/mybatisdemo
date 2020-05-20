package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {

    /**
     * @Description: 获取SelSessionFactory
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/19
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sessionFactory;
    }

    /**
     * @Description: 获取sqlSession
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/19
     */
    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }

    /**
     * @Description: 获取sqlSession
     * ture 标识创建SqlSessiion 对象在执行完sql之后会自动提交事务
     * false 表示 SqlSession在处理完 sql之后 不会自动提交事务
     * @Param:
     * @return:
     * @Author: Mr.Wang
     * @Date: 2020/5/19
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}
