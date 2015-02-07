package com.emarket.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.emarket.domain.User;
import com.emarket.utils.Util;

@Singleton
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public UserDAOImpl() {
		super.setEntityManager(entityManager);
	}

	public User addUser(User User) {

		return super.persist(User);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return super.findAll(User.class);
	}

	public User getUserByID(Long ID) {
		return super.getEntityByID(User.class, ID);
	} 

	public User getUserByUserName(String userName) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<User> result = new ArrayList();
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery(
					"from User where lower(userName) like :userName");
			query.setParameter("userName", userName.toLowerCase());
			result = query.getResultList();
			Util.isNotEmpty(result);
			return Util.isNotEmpty(result) ? result.get(0) : null;
		} finally {
			transaction.commit();
		}

	}

	@Override
	public void updateUserByID(User user) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery(
					"update User u set u.firstName=:firstName , u.lastName=:lastName , u.userName=:userName , u.password=:password where u.ID=:ID");
			
			query.setParameter("ID", user.getID());
			query.setParameter("firstName", user.getFirstName());
			query.setParameter("lastName", user.getLastName());
			query.setParameter("userName", user.getUserName());
			query.setParameter("password", user.getPassword());
			query.executeUpdate();
		} finally {
			transaction.commit();
		}
	}


}
