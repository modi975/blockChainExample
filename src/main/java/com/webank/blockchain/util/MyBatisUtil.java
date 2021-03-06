package com.webank.blockchain.util;

import java.io.InputStream;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
public class MyBatisUtil {
    /**
     * 获取SqlSessionFactory
     * 
     * @return SqlSessionFactory
     */
	private static SqlSessionFactory sessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
    	if (sessionFactory==null) {
	        String resource = "conf.xml";
	        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
	        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    	}
        return sessionFactory;
    }
 
    /**
     * 获取SqlSession
     * 
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();		
    }
 
    /**
     * 获取SqlSession
     * 
     * @param isAutoCommit
     *            true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务 false
     *            表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.
     *            commit()提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
		return getSqlSessionFactory().openSession(isAutoCommit);			
    }
    
}
