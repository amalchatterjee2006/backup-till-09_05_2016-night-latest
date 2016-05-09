package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import model.Product;;
 
		@Repository
		public class ProductDaoImpl 
		{
     
			private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
    
			@Autowired
			private SessionFactory sessionFactory;
     
			public void setSessionFactory(SessionFactory sf)
			{
				this.sessionFactory = sf;
			}
 
    
			public void AddProductDetails(Product p) 
			{
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(p);
				logger.info("Person saved successfully, Person Details="+p);
			}
 
    
			public void UpdateProductDetails(Product p) 
			{
				Session session = this.sessionFactory.getCurrentSession();
				session.update(p);
				logger.info("Person updated successfully, Person Details="+p);
			}
 
			@SuppressWarnings("unchecked")
			public List<Product> ListProductDetails() 
			{
				Session session = this.sessionFactory.getCurrentSession();
				List<Product> productlist = session.createQuery("from Product").list();
        /*for(Person p : personsList){
            logger.info("Person List::"+p);
        }*/
				return productlist;
			}
			@SuppressWarnings("unchecked")
			public List<Product> ListProductDetails1() 
			{
				Session session = this.sessionFactory.getCurrentSession();
				List<Product> productlist1 = session.createQuery("from Product").list();
        /*for(Person p : personsList){
            logger.info("Person List::"+p);
        }*/  
				  System.out.println("hello");
				return productlist1;
			}
            
			
		
    
 /*   public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }*/
 
    
			public void RemoveProductDetails(int id) 
			{
				Session session = this.sessionFactory.getCurrentSession();
				Product p = (Product) session.load(Product.class, new Integer(id));
				if(null != p)
				{
					session.delete(p);
		     	}
				logger.info("Person deleted successfully, person details="+p);
		   }
}
 
