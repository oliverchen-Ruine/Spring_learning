package com.oliver;

import com.GoodsDao;
import com.dao.CustomerDao;
import com.jdk.MyBeanFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/13 9:45
 * @Modified By：
 */
public class ProxyTest {
    @Test
    public void jDKTest(){
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
        customerDao.delete();
        customerDao.updata();
        customerDao.find();
    }
    @Test
    public void cGLIBTest(){
        GoodsDao goodsDao = com.cglib.MyBeanFactory.getBean();
        goodsDao.add();
        goodsDao.delete();
        goodsDao.updata();
        goodsDao.find();
    }
    @Test
    public void xmlTest(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao =(CustomerDao) applicationContext.getBean("customerPoxy");
        customerDao.add();
        customerDao.delete();
        customerDao.updata();
        customerDao.find();
    }
    @Test
    public void xmlAspectJTest(){
        String xmlPath = "applicationRspectJContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.add();
    }
    @Test
    public void annotationAspectJTest(){
        String xmlPath = "applicationRspectJContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.add();
    }
}
