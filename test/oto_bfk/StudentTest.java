package oto_bfk;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class StudentTest {
	
	@Test
	public void testShemaExport(){
		//创建hibernate配置对象
		Configuration config = new Configuration().configure();
//	    ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
//		.applySettings(config.getProperties()).buildServiceRegistry();
//	    SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
	    
//      别用ServiceRegistry导入heibernate配置  
//      new Configuration().configure() 能自动导hibernate.cfg.xml    而且很方便
	    SchemaExport export=new SchemaExport(config);
	    export.create(true,true);
	}
	@Test
	public void addStudent(){
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		IdCard card = new IdCard("12345678912345678", "张三");
		Student stu = new Student(card, "male", new Date(), "太极拳");
		//先保存身份证信息，再保存学生
		session.save(card);
		session.save(stu);
		tx.commit();
	}
}
