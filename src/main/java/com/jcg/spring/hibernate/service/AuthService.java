package com.jcg.spring.hibernate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.jcg.spring.hibernate.pojo.User;

@Transactional(readOnly = false)
public class AuthService {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);

	private AuthService() {
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly = false)
	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean findUser(String uname, String upwd) {
		log.info("Checking the user in the database");
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.name=? and u.password=?";
		try {
			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
			if (userObj != null && userObj.size() > 0) {
				log.info("Id= " + userObj.get(0).getId() + ", Name= " + userObj.get(0).getName() + ", Password= "
						+ userObj.get(0).getPassword());
				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database", e);
		}
		return isValidUser;
	}

	@Transactional(readOnly = false)
	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean deleteUser(int id) {
		User user = new User();;
		log.info(id);
		log.info("Checking the user in the database");
		boolean isDeleteUser = false;
		String sqlQuery = "from user u where u.user_name=?";
		String hqlQuery="delete User u where u.user_id= ?";
		try {
				user=hibernateTemplate.get(User.class,id);
				log.info("Id= " + user.getId() + ", Name= " + user.getName() + ", Password= "
						+ user.getPassword());
					hibernateTemplate.delete(user);	
				isDeleteUser = true;				
		} catch (Exception e) {
			isDeleteUser = false;
			log.error("An error occurred while deleting the user details from the database", e);
		}
		return isDeleteUser;
	}

	@Transactional(readOnly = false)
	@SuppressWarnings({ "deprecation" })
	public boolean editUser(String uname, String newName) {
		log.info("Checking the user in the database");
		boolean isUpdate = true;

		// String hqlQuery = " update Student s set e=s.marks=50 where s.studentId=10;";
		String query = "from User where user_name=?";
		String hqlQuery = "update user u set u.user_name=? where u.user_name=?";
		try {
			User user = (User) hibernateTemplate.find(query, uname);
			user.setName(newName);
			hibernateTemplate.saveOrUpdate(user);
			log.info("Id= " + user.getId() + ", Name= " + user.getName() + ", Password= " + user.getPassword());
			isUpdate = true;
		} catch (Exception e) {
			isUpdate = false;
			log.error("An error occurred while deleting the user details from the database", e);
		}
		return isUpdate;
	}

	@Transactional(readOnly = false)
	public boolean createUser(User user) {
		log.info("Checking the user in the database");
		boolean isUpdate = true;
		// String hqlQuery = " update Student s set e=s.marks=50 where s.studentId=10;"
		try {
			hibernateTemplate.saveOrUpdate(user);
			log.info("Id= " + user.getId() + ", Name= " + user.getName() + ", Password= " + user.getPassword());
			isUpdate = true;
		} catch (Exception e) {
			isUpdate = false;
			log.error("An error occurred while saving  the user details to the database", e);
		}
		return isUpdate;
	}
}