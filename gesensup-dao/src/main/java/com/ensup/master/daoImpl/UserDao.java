package com.ensup.master.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ensup.master.dao.IUserDao;
import com.ensup.master.metier.Course;
import com.ensup.master.metier.Student;
import com.ensup.master.metier.User;

public class UserDao implements IUserDao {

	
	private String url = "jdbc:mysql://localhost/dougschool?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String sql_login = "root";
	private String sql_password = "";
	
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */	 
	@Override
	public User getUser(String login, String password) {
		
		User user = null;
		Query query = null;
		
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			
			query = em.createQuery("select u from User u " + 
                    "where u.login = ?1 and u.password = ?2") ;
			query.setParameter(1, login) ;
			query.setParameter(2,  password) ;
			
			List<User> studentList = new ArrayList<User>(query.getResultList());	
			if(!studentList.isEmpty()) {
				user =  studentList.get(0) ;
			}
				
				//}
			
			em.close();
			
			return user ;
	
	
			}
	
}
