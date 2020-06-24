import com.qf.dao.IUserDao;
import com.qf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisHelloTest {

    @Test
    public void testHello(){

        try {
            // 1.加载MyBatis的配置文件
            InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

            // 2.创建SQLSessionFactory(工厂设计模式)
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

            // 3.通过SqlSessionFactory获取SqlSession(和数据库连接通了)
            SqlSession sqlSession = sqlSessionFactory.openSession();

            // 4.获取代理类(dao层实现类)
            IUserDao userDaoImpl = sqlSession.getMapper(IUserDao.class); // IuserDao接口创建一个代理类

            // 5.调用方法
            User user = userDaoImpl.getUserById(1);

            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
