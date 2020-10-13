package com.ensup.master.daoImpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.PersistentObjectException;

import com.ensup.master.metier.Student;
import com.ensup.master.metier.User;

public class StudentDao {

	private String url = "jdbc:mysql://localhost/dougschool?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String sql_login = "root";
	private String sql_password = "";

	/**
	 * Create a student
	 * 
	 * @param student
	 */
	public void createStudent(Student student) {
		

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			
			em.persist(student);
			
			tx.commit();
			em.close();
			
	}

	/**
	 * read informations student by id
	 * 
	 * @param id
	 * @return student
	 */
	public Student getStudent(int id) {
		
		Student etudiantSelect = new Student();
		
		try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
		EntityManager em = emf.createEntityManager();
		
		 etudiantSelect = em.find(Student.class, id);
		
		  
		
		em.close();
		
		}catch(PersistentObjectException e) {
				
			}
				return etudiantSelect;
			}

	/**
	 * read informations student by email
	 * 
	 * @param email
	 * @return student
	 */
	public Student getStudentByEmail(String email) {
		/*Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			st = cn.createStatement();

			String sql = "SELECT * FROM person WHERE mailAdresse= '" + email + "'";

			rs = st.executeQuery(sql);

			if (rs.next()) {
				return (new Student(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("mailAdresse"), rs.getString("adress"), rs.getString("numberPhone"),
						rs.getString("dateOfBirth")));
			}
			cn.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;*/
		Query query = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
		EntityManager em = emf.createEntityManager(); 
				
		query = em.createQuery("select p from Person p where mailAdresse = ?1 ") ;
		query.setParameter(1, email) ;
		
		Student student = (Student)query.getResultList().get(0);

		return student;
	}

	/**
	 * read all students
	 * 
	 * @return list of students
	 */
	public ArrayList<Student> readAllStudent() {
		
		Query query = null;
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			
			query = em.createQuery("select p from Person p ") ;
			
			ArrayList<Student> studentList = new ArrayList<Student>(query.getResultList());

			return studentList;
		
	}

	/**
	 * delete a student
	 * 
	 * @param id
	 */
	public void deleteStudent(int id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			
			Student etudiantRemove = em.find(Student.class, id);

			  tx.begin();
			  
			  em.remove(etudiantRemove);
			  
			  tx.commit();
			
			em.close();
			
	}catch(PersistentObjectException e) {
			
		}
	}

	/**
	 * update informations student
	 * 
	 * @param student
	 * @return student
	 */
	public void updateStudent(Student student) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();

			
			tx.begin();
			
			Query query = em.createQuery(
			      "UPDATE Person SET firstname = ?1, lastName = ?2, "
			      + "mailAdresse = ?3, adress = ?4, "
			      + "numberPhone = ?5, dateOfBirth = ?6 "
			      + "where id = ?7 ");

			
			
			query.setParameter(1, student.getFirstName()) ;
			query.setParameter(2,  student.getLastName()) ;
			query.setParameter(3, student.getMailAdresse()) ;
			query.setParameter(4,  student.getAdress()) ;
			query.setParameter(5, student.getNumberPhone()) ;
			query.setParameter(6,  student.getDateOfBirth()) ;
			query.setParameter(7, student.getId()) ;
			
			  int updateCount = query.executeUpdate();
			  
			  
			  tx.commit();
			  
				em.close();
			  
	}

	/**
	 * Research a student
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Student> getStudentByResearch(String firstName, String lastName) {
		
		Query query = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ensupJpa");
		EntityManager em = emf.createEntityManager();
		
		if (firstName != "" && lastName != "") {
			query = em.createQuery("select p from Person p where firstName like CONCAT('%',?1,'%') and lastName like CONCAT('%',?2,'%')") ;
			query.setParameter(1, firstName) ;
			query.setParameter(2,  lastName) ;
		}
		else if(firstName != ""){
			query = em.createQuery("select p from Person p where firstName like CONCAT('%',?1,'%')") ;
			query.setParameter(1, firstName) ;
		}
		else if(lastName != ""){
			query = em.createQuery("select p from Person p where lastName like CONCAT('%',?1,'%') ") ;
			query.setParameter(1, lastName) ;

		}
		else {
			query = em.createQuery("select p from Person p") ;
		}
				
		ArrayList<Student> studentList = new ArrayList<Student>(query.getResultList());

		return studentList;
		
	}
}
