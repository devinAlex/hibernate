package mtm_fk;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import mtm_fk.Teachers;
import mtm_fk.Students;

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
		Teachers t1 = new Teachers("T001","dong");
		Teachers t2 = new Teachers("T002","xi");
		Teachers t3 = new Teachers("T003","nan");
		Teachers t4 = new Teachers("T004","bei");
		
		Students s1 = new Students("zhansan","male",new Date(), "compute");
		Students s2 = new Students("lisi","male",new Date(), "yuwei");
		Students s3 = new Students("wangeu","female",new Date(), "compute");
		Students s4 = new Students("zhaoliu","female",new Date(), "yuwei");
		
		Set<Teachers> set1 = new HashSet<Teachers>();
		set1.add(t1);
		set1.add(t2);
		
		Set<Teachers> set2 = new HashSet<Teachers>();
		set2.add(t3);
		set2.add(t4);
		
		Set<Teachers> set3 = new HashSet<Teachers>();
		set3.add(t1);
		set3.add(t3);
		set3.add(t4);
		
		Set<Teachers> set4 = new HashSet<Teachers>();
		set4.add(t2);
		set4.add(t3);
		set4.add(t4);
		s1.setTeachers(set1);
		s2.setTeachers(set2);
		s3.setTeachers(set3);
		s4.setTeachers(set4);
		
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		tx.commit();
	}
}
