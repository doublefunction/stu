package hibernate_day01;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import com.tarena.entity.Category;
import com.tarena.entity.Course;
import com.tarena.entity.Product;
import com.tarena.entity.User;

public class TestOneToMany {
	SessionFactory factory ;
	 @Before
     public void init(){
    	 Configuration cfg =new Configuration();
    	 cfg.configure("hibernate.cfg.xml");
    	 //创建session的工厂
    	  factory =cfg.buildSessionFactory();
     }
	    @Test
	    public void fun01(){
	    	 Session session =factory.openSession();
	         Transaction transaction = session.beginTransaction();
	       
	         transaction.commit();
	         session.close();
	    }
	    //一对多 查询
  @Test
     public void test1select(){
    		//查询一条account数据
    	 Session session =factory.openSession();
 	//	User user =(User) session.get(User.class, 1);
 	Category category =(Category) session.get(Category.class, 1);
 		System.out.println(category.getCname());
 		System.out.println("--------------");
 		//输出关联属性
 		Set<Product> set =category.getProducts();

 		for(Product product : set) {
 			System.out.println(
 				product.getPname()
 			);
 			System.out.println(product.getPrice());
 		}
 		
 		session.close();
     }
  /**
   * 只保存分类,通过级联把当前分类下的商品也保存
    * 配置: 在category.hbm.xml下设置:
    *      <set cascade="save-update">
    */
  //一对多插入
   @Test
   public void fun02(){
	   Session session =factory.openSession();
       Transaction transaction = session.beginTransaction();
       
       Category c1 = new Category();
       c1.setCname("people");
       
       Product p1 = new Product();
       p1.setPname("man");
       p1.setPrice(5);
       
       //c1和p1 产生关系
       c1.getProducts().add(p1);
       //p1和c1产生关系
       p1.setCategory(c1);
       session.save(c1);
       //session.save(p1);不需要了,通过级联保存特性自动保存
       transaction.commit();
       session.close();
   }
   @Test
 //级联删除商品: 删除id为1的类别,级联删除当前类别下的所有商品
 //因为删除的是类别,所有在Category.hbm.xml配置:<set name="products" cascade="delete">
 public void fun03(){
	   Session session =factory.openSession();
       Transaction transaction = session.beginTransaction();
                  
       //先查 id为1的类别
       Category category = (Category) session.get(Category.class, 1);
       session.delete(category);
       transaction.commit();
       session.close();
 }
   @Test
   public void fun04(){
	   Session session =factory.openSession();
       Transaction transaction = session.beginTransaction();
                  
       //先查 id为1的类别
       Category category = (Category) session.get(Category.class, 2);
       category.setCname("566");
       session.update(category);
       transaction.commit();
       session.close();
   }
}
