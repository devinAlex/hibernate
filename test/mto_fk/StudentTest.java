package mto_fk;


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
	public void addStudents(){
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		ClassRoom c1 = new ClassRoom("C001", "ruanjin");
		ClassRoom c2 = new ClassRoom("C002", "ruanjin");
		
		Students s1 = new Students("zhansan","male",new Date(), "compute");
		Students s2 = new Students("lisi","male",new Date(), "yuwei");
		Students s3 = new Students("wangeu","female",new Date(), "compute");
		Students s4 = new Students("zhaoliu","female",new Date(), "yuwei");
		s1.setClassRoom(c1);
		s2.setClassRoom(c1);
		
		s3.setClassRoom(c2);
		s4.setClassRoom(c2);
		
		//先保存班级
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		tx.commit();
	}
}
