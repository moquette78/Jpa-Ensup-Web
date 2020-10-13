package com.ensup.master;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ensup.master.metier.Student;
import com.ensup.master.metier.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	User user = new User();
		Query query = null;
		List<User> studentList;
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			
			query = em.createQuery("select u from User u " + 
                    "where u.login = ?1 and u.password = ?2") ;
			query.setParameter(1, "admin") ;
			query.setParameter(2,  "admin") ;
			
				
				user =  (User) query.getResultList().get(0) ;
				
				//}
			
			em.close();
    }
}
