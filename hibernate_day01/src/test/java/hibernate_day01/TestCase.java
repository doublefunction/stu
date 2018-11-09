package hibernate_day01;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import com.tarena.pojo.User;

public class TestCase {
	SessionFactory factory ;
     @Test
     public void testSession(){
    	 Configuration cfg =new Configuration();
    	 cfg.configure("hibernate.cfg.xml");
    	 //创建session的工厂
    	 SessionFactory factory =cfg.buildSessionFactory();
    	 Session session=factory.openSession();
    	 System.out.println(session);
    	 session.close();
     }
     @Before
     public void init(){
    	 Configuration cfg =new Configuration();
    	 cfg.configure("hibernate.cfg.xml");
    	 //创建session的工厂
    	  factory =cfg.buildSessionFactory();
     }
     @Test
     public void testFactory(){
    	 Session session=factory.openSession();
    	 System.out.println(session);
    	 session.close();
     }
     @Test
     public void testSaveObject(){
    	 User user =new User(100,"Tom","123","OK","cat");
    	 Session session =factory.openSession();
    	 session.save(user);
    	 session.close();
     }
}
