package com.ensup.master.dao;

import com.ensup.master.metier.User;

/**
 * Interface CourseDao
 * 
 * @author DANON
 *
 */
public interface IUserDao {

	public User getUser(String login, String password);
}
