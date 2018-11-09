package hibernate_day01;





import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.log.NullLogger;
import com.tarena.entity.User;

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
    	 User user =new User(101,"tocaa","abc","qwe","3");
    	 Session session =factory.openSession();
    	 Transaction tx= session.beginTransaction();
    	 session.save(user);
    	 tx.commit();
    	 session.close();
     }
     @Test
     public void testUpdateObject(){
    	 Session session=null;
    	 Transaction tx =null;
    	 try {
			session=factory.openSession();//连接数据库
			tx=session.beginTransaction();//开启事务
			//测试更新，找到现有的用户信息
			User user =(User)session.get(User.class,100);
			System.out.println(user);
			user.setName("Jerry");
			session.update(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null)tx.rollback();
		}
    	 finally {
			if(session!=null) session.close();
		}
     }
     @Test
     public void testUpdate(){
    	 Session session=factory.openSession();
    	 Transaction tx =session.beginTransaction();
    	 User user =(User)session.get(User.class,100);
    	 user.setNick("aaaaaaaaa");
    	 tx.commit();
    	 session.close();
     }
     @Test
     public void testEvict(){
    	 Session session =factory.openSession();
    	 Transaction tx =session.beginTransaction();
    	 User user=(User)session.get(User.class, 100);
    	 System.out.println(user);
    	// session.evict(user);
    	session.clear();
    	 user.setNick("bbbbbbbbbbb");
    	 tx.commit();
    	 session.close();
     }
}
